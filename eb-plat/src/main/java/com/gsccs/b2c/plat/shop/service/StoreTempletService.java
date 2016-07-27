package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.StoreTemplet;

/**
 * 站点模板管理
 * @创建人：x.j  niu 
 * @类名称：StoreTempletService
 * @创建时间：2015年4月16日 下午4:53:29
 */
public interface StoreTempletService {
	
	public StoreTemplet findById(long id);
	
	public List<StoreTemplet> find(StoreTemplet storeTemplet , String order);
	
}
