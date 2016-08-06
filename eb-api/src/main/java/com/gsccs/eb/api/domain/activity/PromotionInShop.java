package com.gsccs.eb.api.domain.activity;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 店铺级优惠信息
 * @author x.d zhang
 *
 */
public class PromotionInShop extends Domain {
	
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
