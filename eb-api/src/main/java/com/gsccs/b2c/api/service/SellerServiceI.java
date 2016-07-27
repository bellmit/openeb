package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.b2c.api.domain.Payment;
import com.gsccs.b2c.api.domain.User;
import com.gsccs.b2c.api.exception.ApiException;


/**
 * 商家API 提供了用户基本信息查询功能
 * @author x.d zhang
 *
 */
public interface SellerServiceI {
	
	/**
	 * 查询卖家用户信息（只能查询有店铺的用户） 
	 */
	public User getSeller(Long userId) throws ApiException;
	
	/**
	 * 添加商城卖家账户
	 * @param account
	 */
	public void addStoreAccount(User account);
	
	/**
	 * 查询卖家用户信息（根据账号查询）
	 * @param account
	 * @return
	 * @throws ApiException
	 */
	public User getSeller(String account) throws ApiException;
	
	public List<Payment> getStorePays(String storeid);
	
	public Payment getAlipay(String storeid);

}
