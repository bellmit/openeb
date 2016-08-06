package com.gsccs.b2c.api.domain;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 推荐关联店铺信息
 * @author x.d zhang
 *
 */
public class FavoriteShop extends Domain {
	
	private static final long serialVersionUID = 8456588325597953576L;

	/**
	 * 店铺卖家信用
	 */
	private Long rate;

	/**
	 * 卖家ID
	 */
	private Long sellerId;

	/**
	 * 卖家昵称
	 */
	private String sellerNick;

	/**
	 * 店铺ID
	 */
	private Long shopId;

	/**
	 * 店铺ID
	 */
	private String shopName;

	/**
	 * 店铺LOGO图片
	 */
	private String shopPic;

	/**
	 * 店铺首页链接
	 */
	private String shopUrl;

}
