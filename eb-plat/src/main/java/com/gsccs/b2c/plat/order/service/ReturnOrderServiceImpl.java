package com.gsccs.b2c.plat.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.order.dao.ReturnOrderMapper;
import com.gsccs.b2c.plat.order.model.ReturnOrderExample;
import com.gsccs.b2c.plat.order.model.ReturnOrderExample.Criteria;
import com.gsccs.b2c.plat.order.model.ReturnOrderT;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {
	
	@Autowired
	private ReturnOrderMapper returnOrderMapper;

	@Override
	public List<ReturnOrderT> find(ReturnOrderT returnOrder, Long sid,
			String order, int currPage, int pageSize) {
		ReturnOrderExample example = new ReturnOrderExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(returnOrder,sid, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		if (order!=null && order.trim().length()>0) {
			example.setOrderByClause(order);
		}
		return returnOrderMapper.selectPageByExample(sid, example);
	}

	@Override
	public Long insert(Long sid, ReturnOrderT returnOrder) {
		returnOrderMapper.insert(sid, returnOrder);
		return sid;
	}

	@Override
	public void update(Long sid, ReturnOrderT returnOrder) {
		returnOrderMapper.updateByPrimaryKey(sid, returnOrder);
	}

	@Override
	public ReturnOrderT findById(Long sid, Long roId) {
		return returnOrderMapper.selectByPrimaryKey(sid, roId);
	}

	@Override
	public int count(Long sid,ReturnOrderT returnOrder) {
		ReturnOrderExample example = new ReturnOrderExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(returnOrder,sid, criteria);
		return returnOrderMapper.countByExample(sid, example);
	}
	
	/**
	 * 查询条件
	 * @param orders
	 * @param sid
	 * @param criteria
	 */
	private void proSearchParam(ReturnOrderT returnOrder, Long sid, Criteria criteria) {
		if(null != sid && returnOrder != null ){
		}
	}
}
