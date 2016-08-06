package com.gsccs.b2c.api.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 交易API 
 * 
 * @author x.d zhang
 * 
 */
public interface TradeServiceI {

	/**
	 * 获取产品购买记录列表
	 * 
	 * @param siteid
	 * @param pid
	 */
	public JSONObject getGoodsSaleList_m(Long siteid,Long pid,int page,int rows);

	
}
