package com.gsccs.b2c.api.domain;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 推荐的关联商品
 * 
 * @author x.d zhang
 * 
 */
public class FavoriteItem extends Domain {

	private static final long serialVersionUID = 6857459125343864245L;

	/**
	 * 商品名称
	 */
	private String itemName;

	/**
	 * 商品图片地址
	 */
	private String itemPictrue;

	/**
	 * 商品价格
	 */
	private String itemPrice;

	/**
	 * 商品的详情页面地址
	 */
	private String itemUrl;

	/**
	 * 促销价格
	 */
	private String promotionPrice;

	/**
	 * 商品销售次数
	 */
	private Long sellCount;


}
