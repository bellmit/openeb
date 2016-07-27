package com.gsccs.b2c.plat.site.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.DeliverCorpMapper;
import com.gsccs.b2c.plat.site.dao.DeliverTypeMapper;
import com.gsccs.b2c.plat.site.model.DeliverCorpT;
import com.gsccs.b2c.plat.site.model.DeliverCorpTExample;
import com.gsccs.b2c.plat.site.model.DeliverTypeT;
import com.gsccs.b2c.plat.site.model.DeliverTypeTExample;

/**
 * @说明 商品货运物流接口 快递物流订单查询服务比如申通快递、顺丰快递、圆通快递、EMS快递、汇通快递、宅急送快递等
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 上午9:33:36
 */
@Service
public class DeliverServiceImpl implements DeliverService {

	@Resource
	private DeliverCorpMapper deliverCorpMapper;
	@Resource
	private DeliverTypeMapper deliverTypeTMapper;

	
	
	// 物流公司信息保存
	@Override
	public void saveDeliver(DeliverCorpT logisticsCompany) {
		deliverCorpMapper.insert(logisticsCompany);
	}

	// 根据ID更新物流公司信息
	@Override
	public void updateDeliver(DeliverCorpT logisticsCompany) {
		deliverCorpMapper.updateByPrimaryKey(logisticsCompany);
	}

	// 根据ID删除物流公司信息
	@Override
	public void delete(Integer id) {
		deliverCorpMapper.deleteByPrimaryKey(id);
	}

	// 根据ID查询一条物流公司信息
	@Override
	public DeliverCorpT find(Integer id) {
		return deliverCorpMapper.selectByPrimaryKey(id);
	}

	// 查询所有
	public List<DeliverCorpT> findtAll() {
		return deliverCorpMapper.selectAll();
	}

	@Override
	public List<DeliverCorpT> find(DeliverCorpT t, String order, int currPage,
			int pageSize, boolean cache) {
		DeliverCorpTExample example = new DeliverCorpTExample();
		DeliverCorpTExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return deliverCorpMapper.selectPageByExample(example);
	}

	@Override
	public int count(DeliverCorpT t) {
		DeliverCorpTExample example = new DeliverCorpTExample();
		DeliverCorpTExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		return deliverCorpMapper.countByExample(example);
	}

	@Override
	public List<DeliverTypeT> find(DeliverTypeT t, String order, int currPage,
			int pageSize, boolean cache) {
		DeliverTypeTExample example = new DeliverTypeTExample();
		DeliverTypeTExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return deliverTypeTMapper.selectPageByExample(example);
	}

	@Override
	public int count(DeliverTypeT t) {
		DeliverTypeTExample example = new DeliverTypeTExample();
		DeliverTypeTExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		return deliverTypeTMapper.countByExample(example);
	}

	public void proSearchParam(DeliverCorpT t,
			DeliverCorpTExample.Criteria criteria) {

	}

	public void proSearchParam(DeliverTypeT t,
			DeliverTypeTExample.Criteria c) {
		if (null != t){
			if (null != t.getSiteid()){
				System.out.println("sid=="+t.getSiteid());
				c.andSiteidEqualTo(t.getSiteid());
			}
		}
	}
	
	
	public DeliverTypeT get(Long siteid,String id){
		
		return null;
	}

	@Override
	public List<DeliverTypeT> get(DeliverTypeT t) {
		DeliverTypeTExample example = new DeliverTypeTExample();
		DeliverTypeTExample.Criteria c = example.createCriteria();
		proSearchParam(t, c);
		return deliverTypeTMapper.selectByExample(example);
	}

	//根据id删除支付方式
	@Override
	public void delDeliverType(String id) {
		deliverTypeTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<DeliverCorpT> findAllDeliverCorpt() {
		return deliverCorpMapper.selectAll();
	}

	@Override
	public void saveDeliverTypeT(DeliverTypeT dtt) {
		long tid = findMaxId();
		dtt.setId(tid+"");
		deliverTypeTMapper.insert(dtt);
	}

	@Override
	public void updateDeliverTypeT(DeliverTypeT deliverCorpT) {
		deliverTypeTMapper.updateByPrimaryKey(deliverCorpT);
	}

	@Override
	public DeliverTypeT find(String id) {
		return deliverTypeTMapper.selectByPrimaryKey(id);
	}

	/**
	 * 获取模板Id
	 */
	public Long findMaxId() {
		Long deliverTypeId = deliverTypeTMapper.selectMaxId();
		if (null == deliverTypeId) {
			deliverTypeId = (long) 100;
		}
		deliverTypeId = deliverTypeId + 1;
		return deliverTypeId;
	}
}
