package com.gsccs.eb.api.domain.coupon;

import java.util.Date;

import com.gsccs.eb.api.domain.base.Domain;


/**
 * 折扣详情信息
 * @author x.d zhang
 *
 */
public class DiscountDetail extends Domain {
	
	
	private static final long serialVersionUID = 6369914341788122315L;

	/**
	 * 创建时间
	 */
	private Date created;

	/**
	 * 折扣详情ID
	 */
	private Long detailId;

	/**
	 * 优惠方式:PERCENT（按折扣优惠）、PRICE（按减价优惠）
	 */
	private String discountType;

	/**
	 * 优惠比率或者优惠价格 10%或10
	 */
	private Long discountValue;

	/**
	 * 修改时间
	 */
	private Date modified;

	/**
	 * 会员等级的id
	 */
	private Long targetId;

	/**
	 * 等级名称
	 */
	private String targetName;

	/**
	 * 折扣类型:GRADE（按会员等级优惠）
	 */
	private String targetType;

}
