package com.gsccs.b2c.store.service;


import com.alibaba.fastjson.JSONArray;

/**
 * 商家缓存接口
 * @author niu x j 
 *
 */
public interface SsdbService {

	/**
	 * 获得商品图片
	 * @param sid
	 * @param pid
	 * @return
	 */
	public JSONArray getProductImgs(Long sid,Long pid);
	
	/**
	 * 获得商品描述
	 * @param sid
	 * @param pid
	 * @return
	 */
	public String getProductDesc(Long sid,Long pid);
}
