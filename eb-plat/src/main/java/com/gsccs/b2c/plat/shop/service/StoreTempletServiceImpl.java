package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.StoreTempletMapper;
import com.gsccs.b2c.plat.shop.model.StoreTemplet;
import com.gsccs.b2c.plat.shop.model.StoreTempletExample;
import com.gsccs.b2c.plat.shop.model.StoreTempletExample.Criteria;

@Service
public class StoreTempletServiceImpl implements StoreTempletService{

	@Autowired
	private StoreTempletMapper storeTempletMapper;

	@Override
	public StoreTemplet findById(long id) {
		return storeTempletMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<StoreTemplet> find(StoreTemplet storeTemplet , String order){
		StoreTempletExample  example = new StoreTempletExample();
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
	public void proSearchParam(StoreTemplet storeTemplet,Criteria criteria){
		if(storeTemplet != null){
			if(storeTemplet.getStoreid() != null){
				criteria.andStoreidEqualTo(storeTemplet.getStoreid());
			}
		}
	}
	
	
}
