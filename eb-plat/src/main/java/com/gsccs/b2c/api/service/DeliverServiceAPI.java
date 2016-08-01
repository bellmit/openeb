package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.deliver.model.Corp;
import com.gsccs.b2c.plat.deliver.model.Templet;
import com.gsccs.b2c.plat.deliver.service.DeliverService;
import com.gsccs.b2c.plat.utils.BeanUtilsEx;
import com.gsccs.eb.api.domain.deliver.DeliverType;
import com.gsccs.eb.api.domain.deliver.DlyCorp;

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
	public void saveDlyCorp(DlyCorp d) {
		Corp t = new Corp();
		try {
			BeanUtils.copyProperties(t, d);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		deliverService.saveDeliver(t);
	}

	// 根据ID更新物流公司信息
	@Override
	public void updateDlyCorp(DlyCorp d) {
		Corp t = new Corp();
		try {
			BeanUtils.copyProperties(t, d);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		deliverService.updateDeliver(t);
	}

	// 通过ID查询一条物流公司
	@Override
	public DlyCorp findDlyCorp(Integer id) {

		Corp t = deliverService.find(id);
		if(null !=t){
			DlyCorp d = new DlyCorp();
			BeanUtilsEx.copyProperties(d, t);
			return d;
		}
		return null;
		
	}

	// 查询所有物流公司列表
	@Override
	public List<DlyCorp> findCorps(DlyCorp param, int currPage, int pageSize) {
		List<DlyCorp> domianList = new ArrayList<DlyCorp>();
		List<Corp> datas = null;
		Corp param_ = new Corp();
		if (null != param) {
			try {
				BeanUtils.copyProperties(param_, param);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		datas = deliverService.find(param_, "", currPage, pageSize, true);

		DlyCorp d = null;
		for (Corp t : datas) {
			d = new DlyCorp();
			try {
				BeanUtils.copyProperties(d, t);
				domianList.add(d);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return domianList;
	}

	@Override
	public List<DeliverType> findDeliverTypeList(DeliverType param, int currPage, int pageSize) {
		List<DeliverType> typeList = new ArrayList<DeliverType>();
		List<Templet> datas = null;
		Templet param_ = new Templet();
		if (null != param) {
			try {
				BeanUtils.copyProperties(param_, param);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		datas = deliverService.find(param_, "", currPage, pageSize, true);

		DeliverType d = null;
		for (Templet t : datas) {
			d = new DeliverType();
			try {
				BeanUtils.copyProperties(d, t);
				typeList.add(d);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
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
	public List<DeliverType> findDeliverTypes(Long siteId) {
		Templet deliverTypeT = new Templet();
		deliverTypeT.setSiteid(siteId);
		
		List<DeliverType> dList = new ArrayList<DeliverType>();
		DeliverType dType = null;
		List<Templet> dtList =deliverService.get(deliverTypeT);
		for (Templet dTypeT : dtList) {
			dType = new DeliverType();
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
	public void delDeliverType(String ids) {
		String[] pids = ids.split(",");
		if(pids !=null){
			for (String s : pids) {
				deliverService.delDeliverType(s);
			}
		}
	}

	@Override
	public int count(DeliverType dt) {
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
	public List<DlyCorp> findCorps() {
		List<DlyCorp> dcList = new ArrayList<DlyCorp>();
		DlyCorp  dc = null;
		List<Corp> dctList = deliverService.findAllDeliverCorpt();
		if(null != dctList){
			for (Corp dct : dctList) {
				dc = new DlyCorp();
				try {
					BeanUtils.copyProperties(dc, dct);
					dcList.add(dc);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dcList;
	}

	@Override
	public void saveDeliverType(DeliverType deliverType) {
		Templet dtt = new Templet();
		try {
			BeanUtils.copyProperties(dtt, deliverType);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		deliverService.saveDeliverTypeT(dtt);
	}

	@Override
	public void updateDeliverType(DeliverType deliverType) {
		Templet dtt = new Templet();
		try {
			BeanUtils.copyProperties(dtt, deliverType);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		deliverService.updateDeliverTypeT(dtt);
		
	}

	@Override
	public DeliverType findDeliverType(String id) {
		try {
			Templet dtt = deliverService.find(id);
			DeliverType dt = new DeliverType();
			BeanUtils.copyProperties(dt, dtt);
			return dt;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
