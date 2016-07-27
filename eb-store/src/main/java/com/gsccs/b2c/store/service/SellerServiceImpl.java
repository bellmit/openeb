package com.gsccs.b2c.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.api.service.SellerServiceI;


@Service
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	private SellerServiceI sellerApi;

	@Override
	public Account getSeller(long uid, long sid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
