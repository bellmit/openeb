package com.gsccs.eb.api.domain.seller;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 店铺动态评分信息
 * 
 * @author x.d zhang
 * 
 */
public class ShopScore extends Domain {

	private static final long serialVersionUID = 6878471649455693464L;

	/**
	 * 发货速度评分
	 */
	private Long deliveryScore;

	/**
	 * 商品描述评分
	 */
	private Long itemScore;

	/**
	 * 服务态度评分
	 */
	private Long serviceScore;
}
