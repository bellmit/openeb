package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.StoreNav;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 店铺API 提供了店铺查询，店铺自定义类目的查询和更新。
 * 
 * @author x.d zhang
 * 
 */
public interface ShopServiceI {

	/**
	 * 获取卖家店铺的基本信息
	 * 
	 * @throws Throwable
	 */

	public Shop getShop(Long sid) throws ApiException;


	public void editStore(Long sid, Integer stockalertnum) throws ApiException;

	/**
	 * 店铺导航菜单栏
	 * 
	 * @param sid
	 * @return
	 */
	public List<StoreNav> getStoreNav(Long sid);
}
