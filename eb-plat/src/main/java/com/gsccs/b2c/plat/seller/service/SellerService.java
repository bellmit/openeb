package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import com.gsccs.b2c.plat.shop.model.SellerAccount;
import com.gsccs.b2c.plat.shop.model.StoreT;


public interface SellerService {

	public Long insert(SellerAccount sellerAccount);
	
	public void update(SellerAccount sellerAccount);
	
	public SellerAccount findById(Long sid);
	
	public SellerAccount findByAccount(String account);
	
	public List<SellerAccount> find(SellerAccount account);
	/**
	 * 分页查询
	 */
	public List<SellerAccount> find(SellerAccount account, String order, int currPage,
			int pageSize);
	public int count(SellerAccount account);
}
