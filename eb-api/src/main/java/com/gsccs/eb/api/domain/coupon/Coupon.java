package com.gsccs.eb.api.domain.coupon;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 优惠券数据结构
 * 
 * @author x.d zhang
 * 
 */
public class Coupon extends Domain {

	private static final long serialVersionUID = 8573392697578657316L;

	/**
	 * 优惠券ID
	 */
	private Long couponId;

	/**
	 * 订单满多少分才能用这个优惠券，501就是满501分能使用。注意：返回的是“分”，不是“元”
	 */
	private Long condition;

	/**
	 * 优惠券创建时间
	 */
	private Date creatTime;

	/**
	 * 优惠券的面值，返回的是“分”，不是“元”，500代表500分相当于5元
	 */
	private Long denominations;

	/**
	 * 优惠券的截止日期
	 */
	private Date endTime;
	
	
	

}
