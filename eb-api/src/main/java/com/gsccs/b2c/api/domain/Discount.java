package com.gsccs.b2c.api.domain;

import java.util.Date;
import java.util.List;

/**
 * 折扣信息
 * @author x.d zhang
 *
 */
public class Discount extends DomainObject {

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
