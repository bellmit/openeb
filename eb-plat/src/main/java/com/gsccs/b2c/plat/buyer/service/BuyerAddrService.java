package com.gsccs.b2c.plat.buyer.service;

import java.util.List;

import com.gsccs.b2c.plat.buyer.model.BuyerDeliverT;

/**
 * @说明 会员中心---收货地址保存服务类
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 下午5:08:23
 */
public interface BuyerAddrService {

	// 保存一条会员收货地址
	public void saveDeliverAddress(Long sid, BuyerDeliverT DeliverAddress);

	// 删除一条收货地址
	public void deleteDeliverAddress(Long sid, Long addressid);

	// 更新收货地址
	public void updateDeliverAddress(Long sid, BuyerDeliverT DeliverAddress);

	// 查询会员多个收货地址
	List<BuyerDeliverT> deliverAddressList(Long sid, Long uid);

	BuyerDeliverT getDeliver(Long sid, Long uid, Long addressid);

}
