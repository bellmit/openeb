package com.gsccs.b2c.api.domain;

/**
 * 店铺级优惠信息
 * @author x.d zhang
 *
 */
public class PromotionInShop extends DomainObject {
	
	private static final long serialVersionUID = 3384176235384614394L;

	/**
	 * 优惠活动名称
	 */
	private String name;

	/**
	 * 优惠详情描述。
	 */
	private String promotionDetailDesc;

	/**
	 * idValue值
	 */
	private String promotionId;

}
