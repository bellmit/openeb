package com.gsccs.b2c.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.domain.Category;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 类目API 提供了标准类目，类目属性和类目属性值的查询功能
 * 
 * @author x.d zhang
 * 
 */
public interface CateServiceI {

	/**
	 * 获取平台类目树
	 * 
	 * @param state
	 * @return
	 */
	public JSONArray getAllCategorys(String state);

	/**
	 * 获取站点根类目
	 * 
	 * @param siteId
	 *            。如果siteId为空，则获取平台所有根类目
	 * @return
	 */
	public List<Category> getRootCates(Long siteId);

	/**
	 * 获取类目详情
	 * 
	 * @param cateId
	 * @return
	 */
	public Category getCate(Long cateId);
	
	/**
	 * 商城管理系统类目
	 * @param siteId
	 * @return
	 * @throws ApiException
	 */
	public JSONArray getStoreCates(Long siteId) throws ApiException;
	
	/**
	 * 商城管理类目
	 * @param siteId
	 * @param parid
	 * @return
	 * @throws ApiException
	 */
	public JSONArray getStoreCates(Long siteId,Long parid) throws ApiException;

	/**
	 * 获取站点类目树
	 * 
	 * @param siteId
	 * @param parId
	 * @return
	 */
	public JSONArray getSiteCates(Long siteId) throws ApiException;

}
