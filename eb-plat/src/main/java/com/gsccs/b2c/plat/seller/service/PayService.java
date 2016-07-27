package com.gsccs.b2c.plat.seller.service;

import java.util.List;

import com.gsccs.b2c.plat.seller.model.SellerPay;

/**
 * 支付接口
 * @author think
 *
 */
public interface PayService {
	
	/**
	 * 商家支付方式
	 * @param storeid
	 * @return
	 */
	public List<SellerPay> getPayments(String storeid);
	
	
	/**
	 * 根据商家及支付方式获取支付参数
	 * @param storeid
	 * @param type(alipay,unionpay,wxpay)
	 * @return
	 */
	public SellerPay getPaymentByType(String storeid,String type);
	

}
