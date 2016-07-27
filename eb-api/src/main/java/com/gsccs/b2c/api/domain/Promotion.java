package com.gsccs.b2c.api.domain;

import java.util.Date;


/**
 * 优惠活动
 * @author x.d zhang
 *
 */
public class Promotion extends DomainObject {
	
	private static final long serialVersionUID = 8248517485872762542L;

	/**
	 * 减价件数，1只减一件，0表示多件
	 */
	private Long decreaseNum;

	/**
	 * 优惠类型，PRICE表示按价格优惠，DISCOUNT表示按折扣优惠
	 */
	private String discountType;

	/**
	 * 优惠额度
	 */
	private String discountValue;

	/**
	 * 优惠结束日期
	 */
	private Date endDate;

	/**
	 * 商品数字ID
	 */
	private Long numIid;

	/**
	 * 优惠描述
	 */
	private String promotionDesc;

	/**
	 * 优惠ID
	 */
	private Long promotionId;

	/**
	 * 优惠标题，显示在宝贝详情页面的优惠图标的tip。
	 */
	private String promotionTitle;

	/**
	 * 优惠开始日期
	 */
	private Date startDate;

	/**
	 * 优惠策略状态，ACTIVE表示有效，UNACTIVE表示无效
	 */
	private String status;

	/**
	 * 对应的人群标签ID
	 */
	private Long tagId;

}
