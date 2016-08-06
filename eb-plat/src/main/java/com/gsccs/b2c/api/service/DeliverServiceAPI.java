package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.deliver.service.DeliverService;
import com.gsccs.eb.api.domain.deliver.Corp;
import com.gsccs.eb.api.domain.deliver.Templet;

/**
 * 物流服务层
 * 
 * @author x.d zhang
 */
public class DeliverServiceAPI implements DeliverServiceI {

	@Autowired
	private DeliverService deliverService;

	// 物流公司信息保存
	@Override
	public void saveCorp(Corp corp) {
		deliverService.saveCorp(corp);
	}

	
	// 通过ID查询一条物流公司
	@Override
	public Corp findCorp(Integer id) {
		return deliverService.getCorp(id);
	}

	// 查询所有物流公司列表
	@Override
	public List<Corp> findCorps(Corp param, int currPage, int pageSize) {
		List<Corp> corpList = deliverService.find(param, "", currPage, pageSize, true);
		return corpList;
	}

	@Override
	public List<Templet> findTypeList(Templet param, int currPage, int pageSize) {
		List<Templet> typeList = deliverService.find(param, "", currPage, pageSize, true);
		return typeList;
	}

	/**
	 * 计算物流费用
	 * 
	 * @param siteId
	 * @param dlyTypeId
	 * @param areaId
	 * @param weight
	 * @return
	 */
	public Float calculateFee(Long siteId, String dlyTypeId, String areaId,
			Integer weight) {
		// 首重费用
		float firstFee = 0.00f;
		// 续重费用
		float contiFee = 0.00f;
		// 报价费用
		float protectFee = 0.00f;

		if (null != siteId && StringUtils.isNotEmpty(dlyTypeId)) {
			Templet type = deliverService.get(siteId, dlyTypeId);
			if (null != type) {
				firstFee = type.getFirstunit() * type.getFirstprice();
				if (null != type.getContinueunit()
						&& type.getContinueunit() != 0) {
					BigDecimal b = new BigDecimal(weight
							/ type.getContinueunit());
					BigDecimal unit = b.setScale(0, BigDecimal.ROUND_HALF_UP);
					contiFee = unit.intValue() * type.getContinueprice();
				}

				if (type.isProtectPrice()) {
					if (null != type.getProtectRate()) {
						protectFee = (firstFee + contiFee)
								* type.getProtectRate();
					}

					if (null != type.getMinprice()) {
						if (type.getMinprice() > protectFee) {
							protectFee = type.getMinprice();
						}
					}
				}
			}
		}
		return firstFee + contiFee + protectFee;
	}

	@Override
	public List<Templet> findDeliverTypes(Long siteId) {
		Templet deliverTypeT = new Templet();
		deliverTypeT.setSiteid(siteId);
		
		List<Templet> dList = new ArrayList<Templet>();
		Templet dType = null;
		List<Templet> dtList =deliverService.get(deliverTypeT);
		for (Templet dTypeT : dtList) {
			dType = new Templet();
			try {
				BeanUtils.copyProperties(dType, dTypeT);
				dList.add(dType);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		return dList;
	}

	@Override
	public void delType(String ids) {
		String[] pids = ids.split(",");
		if(pids !=null){
			for (String s : pids) {
				deliverService.delDeliverType(s);
			}
		}
	}

	@Override
	public int count(Templet dt) {
		Templet dtt= new Templet();
		if(null != dt){
			try {
				BeanUtils.copyProperties(dtt, dt);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return deliverService.count(dtt);
	}

	

	@Override
	public void saveType(Templet templet) {
		deliverService.saveType(templet);
	}


	@Override
	public Templet findType(String id) {
		Templet templet = deliverService.find(id);
		return templet;
	}
}
