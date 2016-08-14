package com.gsccs.b2c.plat.pay.service;

import java.util.List;

import com.gsccs.b2c.plat.seller.model.StorePay;
import com.gsccs.eb.api.domain.trade.PayArgs;
import com.gsccs.eb.api.domain.trade.PayType;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 支付接口
 * 
 * @author x.d zhang
 * 
 */
public interface PayService {

	/**
	 * 支付方式
	 * 
	 * @return
	 */
	public List<PayType> queryPayTypes(PayType payType, int page, int pagesize);

	/**
	 * 根据商家及支付方式获取支付参数
	 * 
	 * @param type
	 *            (alipay,unionpay,wxpay)
	 * @return
	 */
	public PayType getPayType(String id);
	
	/**
	 * 新增支付类型
	 * 
	 * @param type
	 * @return
	 */
	public String savePayType(PayType type);

	/**
	 * 新增支付参数
	 * 
	 * @param args
	 * @return
	 */
	public JsonMsg savePayArgs(PayArgs args);


	public PayArgs getPayArgs(String id);

	/**
	 * 支付参数
	 * 
	 * @return
	 */
	public List<PayArgs> queryPayArgs(PayArgs payArgs, int page, int pagesize);

	/**
	 * 支付参数
	 * 
	 * @return
	 */
	public List<PayArgs> queryPayArgs(Long shopid,String paytypeid);

}
