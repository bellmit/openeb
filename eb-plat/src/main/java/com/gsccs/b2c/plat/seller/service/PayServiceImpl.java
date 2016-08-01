package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.seller.dao.StorePayMapper;
import com.gsccs.b2c.plat.seller.model.StorePay;
import com.gsccs.b2c.plat.seller.model.StorePayExample;
import com.gsccs.b2c.plat.seller.model.StorePayExample.Criteria;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private StorePayMapper sellerPayMapper;
	
	@Override
	public List<StorePay> getPayments(String storeid) {
		StorePayExample example = new StorePayExample();
		Criteria c = example.createCriteria();
		c.andStoreIdEqualTo(storeid);
		return sellerPayMapper.selectByExample(example);
	}

	@Override
	public StorePay getPaymentByType(String storeid, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
