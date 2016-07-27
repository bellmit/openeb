package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.seller.dao.SellerPayMapper;
import com.gsccs.b2c.plat.seller.model.SellerPay;
import com.gsccs.b2c.plat.seller.model.SellerPayExample;
import com.gsccs.b2c.plat.seller.model.SellerPayExample.Criteria;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private SellerPayMapper sellerPayMapper;
	
	@Override
	public List<SellerPay> getPayments(String storeid) {
		SellerPayExample example = new SellerPayExample();
		Criteria c = example.createCriteria();
		c.andStoreIdEqualTo(storeid);
		return sellerPayMapper.selectByExample(example);
	}

	@Override
	public SellerPay getPaymentByType(String storeid, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
