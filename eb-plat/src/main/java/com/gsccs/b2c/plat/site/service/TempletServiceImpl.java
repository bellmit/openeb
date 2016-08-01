package com.gsccs.b2c.plat.site.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.TempletMapper;
import com.gsccs.b2c.plat.site.model.Templet;
import com.gsccs.b2c.plat.site.model.TempletExample;
import com.gsccs.b2c.plat.site.model.TempletExample.Criteria;

@Service
public class TempletServiceImpl implements TempletService {

	@Autowired
	private TempletMapper templetMapper;

	@Override
	public List<Templet> find(Templet templet, String order) {

		TempletExample example = new TempletExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(templet, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		return templetMapper.selectByExample(example);
	}

	@Override
	public List<Templet> find(Templet templet, String order, int currPage,
			int pageSize) {
		TempletExample example = new TempletExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(templet, criteria);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return templetMapper.selectByExample(example);
	}

	@Override
	public Long insert(Templet templet) {
		long tid = findMaxTempletId();
		templet.setId(tid);
		templetMapper.insert(templet);
		return tid;
	}

	@Override
	public void update(Templet templet) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(Long templetId, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public Templet findById(Long id) {
		return templetMapper.selectByPrimaryKey(id);
	}

	/**
	 * 处理查询条件
	 * 
	 * @param example
	 * @param criteria
	 */
	public void proSearchParam(Templet templet, Criteria criteria) {
		if (templet != null) {
			if (templet.getId() != null) {
				criteria.andIdEqualTo(templet.getId());
			}
			if (templet.getName() != null
					&& templet.getName().trim().length() > 0) {
				criteria.andNameLike("'%" + templet.getName() + "%'");
			}
		}
	}

	/**
	 * 获取模板Id
	 */
	public Long findMaxTempletId() {
		Long templetId = templetMapper.selectMaxId();
		if (null == templetId) {
			templetId = (long) 1000;
		}
		templetId = templetId + 1;
		return templetId;
	}

	@Override
	public int count(Templet templet) {
		TempletExample example = new TempletExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(templet, criteria);
		return templetMapper.countByExample(example);
	}

}
