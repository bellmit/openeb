package com.gsccs.eb.api.domain.activity;

import java.util.List;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 优惠信息对象
 * @author x.d zhang
 *
 */
public class PromotionDisplayTop extends Domain{
	
	private static final long serialVersionUID = 5167558191844527721L;

	/**
	 * 单品级优惠信息
	 */
	private List<PromotionInItem> promotionInItem;

	/**
	 * 店铺级优惠信息
	 */
	private List<PromotionInShop> promotionInShop;


}
