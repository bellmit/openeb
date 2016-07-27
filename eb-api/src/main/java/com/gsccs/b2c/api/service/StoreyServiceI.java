package com.gsccs.b2c.api.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.eb.api.domain.site.Storey;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 楼层管理API 提供了首页楼层的编辑功能
 * @author ZhangTao
 *
 */
public interface StoreyServiceI {

	/**
	 * 添加楼层信息
	 * @param sid
	 * @param storey
	 * @return
	 */
	public void addStorey(Long sid, JSONObject storeyList) throws ApiException ;
	
	/**
	 * 添加Banner
	 * @param sid
	 * @param storeyList
	 * @throws ApiException
	 */
	public void addBanner(Long sid, JSONArray banners) throws ApiException ;
	
	/**
	 * 删除楼层
	 * @param sid
	 * @param storeyid
	 * @throws ApiException
	 */
	public void delStorey(Long sid, String storeyid) throws ApiException ;
	
	/**
	 * 查询商城楼层数据
	 * @param sid
	 * @return
	 */
	public JSONObject findStoreyList(Long sid);
	
}
