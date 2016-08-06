package com.gsccs.eb.api.domain.coupon;

import java.util.Date;
import java.util.List;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 折扣信息
 * @author x.d zhang
 *
 */
public class Discount extends Domain {

	private static final long serialVersionUID = 6629334199677469213L;

	/**
	 * 创建时间
	 */
	private Date created;

	/**
	 * 折扣详情
	 */
	private List<DiscountDetail> details;

	/**
	 * 折扣ID
	 */
	private Long discountId;

	/**
	 * 修改时间
	 */
	private Date modified;

	/**
	 * 折扣名称
	 */
	private String name;
}
