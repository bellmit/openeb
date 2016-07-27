package com.gsccs.b2c.api.domain;

import java.util.Date;
import java.util.List;


/**
 * 单品级优惠信息
 * @author x.d zhang
 *
 */
public class PromotionInItem extends DomainObject {
	
	private static final long serialVersionUID = 5467138586553223741L;

	/**
	 * 优惠描述
	 */
	private String desc;

	/**
	 * 优惠结束时间
	 */
	private Date endTime;

	/**
	 * 优惠折后价格
	 */
	private String itemPromoPrice;

	/**
	 * 优惠展示名称
	 */
	private String name;

	/**
	 * 需要支付附加物，显示为+xxx。如：+20淘金币
	 */
	private String otherNeed;

	/**
	 * 赠送东西。如：送10商城积分
	 */
	private String otherSend;

	/**
	 * idValue的值
	 */
	private String promotionId;

	/**
	 * sku价格对应的id（保证二者顺序相同）
	 */
	private List<String> skuIdList;

	/**
	 * sku价格列表
	 */
	private List<String> skuPriceList;

	/**
	 * 优惠开始时间
	 */
	private Date startTime;

}
