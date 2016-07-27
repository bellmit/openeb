package com.gsccs.b2c.plat.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.order.dao.OrderPayTMapper;
import com.gsccs.b2c.plat.order.model.OrderPayT;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private OrderPayTMapper orderPayTMapper;

	@Override
	public void addOrderPay(OrderPayT orderPayT) {
		if (null != orderPayT) {
			orderPayTMapper.insert(orderPayT);
		}
	}

}
