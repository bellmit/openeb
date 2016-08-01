package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.SiteTempletMapper;
import com.gsccs.b2c.plat.site.model.SiteTemplet;
import com.gsccs.b2c.plat.site.model.SiteTempletExample;
import com.gsccs.b2c.plat.site.model.SiteTempletExample.Criteria;

@Service
public class StoreTempletServiceImpl implements StoreTempletService{

	@Autowired
	private SiteTempletMapper storeTempletMapper;

	@Override
	public SiteTemplet findById(long id) {
		return storeTempletMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<SiteTemplet> find(SiteTemplet storeTemplet , String order){
		SiteTempletExample  example = new SiteTempletExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(storeTemplet, criteria);
		if (order!=null && order.trim().length()>0) {
			example.setOrderByClause(order);
		}
		return storeTempletMapper.selectByExample(example);
	}
	
	/**
	 * 处理查询条件
	 * @param example
	 * @param criteria
	 */
	public void proSearchParam(SiteTemplet storeTemplet,Criteria criteria){
		if(storeTemplet != null){
			if(storeTemplet.getStoreid() != null){
				criteria.andStoreidEqualTo(storeTemplet.getStoreid());
			}
		}
	}
	
	
}
