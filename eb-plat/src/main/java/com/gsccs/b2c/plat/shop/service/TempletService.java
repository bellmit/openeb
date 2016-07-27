package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gsccs.b2c.plat.shop.model.Templet;

/**
 * 模板管理
 * @创建人：x.j  niu 
 * @类名称：TempletService
 * @创建时间：2015年4月9日 上午9:05:04
 */
public interface TempletService {
	
	/**
	 * 根据条件查询模板
	 * @param templet
	 * @param order
	 * @return
	 */
	public List<Templet> find(Templet templet, String order);
	
	/**
	 * 根据条件分页查询
	 * @param templet
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	public List<Templet> find(Templet templet, String order, int currPage,
			int pageSize) ;
	
	/**
	 * 查询总数
	 * @param templet
	 * @return
	 */
	public int count(Templet templet);
	
	/**
	 * 添加模板
	 * @param templet
	 * @return
	 */
	public Long insert(Templet templet);
	
	/**
	 * 修改模板
	 * @param templet
	 */
	public void update(Templet templet);
	
	/**
	 * 修改模板
	 * @param templetId
	 * @param request
	 */
	public void del(Long templetId, HttpServletRequest request);
	
	/**
	 * 根据Id查询模板
	 * @param id
	 * @return
	 */
	public Templet findById(Long id);
}
