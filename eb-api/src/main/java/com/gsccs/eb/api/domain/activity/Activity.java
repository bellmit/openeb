package com.gsccs.eb.api.domain.activity;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 活动数据结构
 * 
 * @author x.d zhang
 * 
 */
public class Activity extends Domain {

	private static final long serialVersionUID = 4468427473728698992L;

	/**
	 * 活动id
	 */
	private Long activityId;

	/**
	 * 领用优惠券的链接
	 */
	private String activityUrl;

	/**
	 * 已经领取的优惠券的数量
	 */
	private Long appliedCount;

	/**
	 * 活动对应的优惠券ID
	 */
	private Long couponId;

	/**
	 * self代表自己创建，other他人创建
	 */
	private String createUser;

	/**
	 * 每个买家限领取优惠券的数量，1～5张
	 */
	private Long personLimitCount;

	/**
	 * enabled代表有效，invalid代表失效。other代表空值
	 */
	private String status;

	/**
	 * 卖家设置优惠券领取的总领用量
	 */
	private Long totalCount;
}
