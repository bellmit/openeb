package com.gsccs.eb.api.domain.activity;

import com.gsccs.eb.api.domain.base.Domain;

public class PromotionDetail extends Domain {
	
	private static final long serialVersionUID = 4621223357477477886L;

	/**
	 * 优惠金额（免运费、限时打折时为空）,单位：元
	 */
	private String discountFee;

	/**
	 * 赠品的宝贝id
	 */
	private String giftItemId;

	/**
	 * 满就送商品时，所送商品的名称
	 */
	private String giftItemName;

	/**
	 * 满就送礼物的礼物数量
	 */
	private String giftItemNum;

	/**
	 * 交易的主订单或子订单号
	 */
	private Long id;

	/**
	 * 优惠活动的描述
	 */
	private String promotionDesc;

	/**
	 * 优惠id，(由营销工具id、优惠活动id和优惠详情id组成，结构为：营销工具id-优惠活动id_优惠详情id，如mjs-123024_211143）
	 */
	private String promotionId;

	/**
	 * 优惠信息的名称
	 */
	private String promotionName;

}
