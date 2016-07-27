package com.gsccs.b2c.api.domain;

/**
 * 发货时间数据结构
 * 
 * @author x.d zhang
 * 
 */
public class DeliveryTime extends DomainObject {

	private static final long serialVersionUID = 3552635889822732342L;

	/**
	 * 商品级别设置的发货时间。设置了商品级别的发货时间，相对发货时间，则填写相对发货时间的天数（大于3）；绝对发货时间，则填写yyyy-mm-dd格式，
	 * 如2013-11-11
	 */
	private String deliveryTime;

	/**
	 * 发货时间类型：绝对发货时间或者相对发货时间
	 */
	private String deliveryTimeType;

	/**
	 * 设置是否使用发货时间，商品级别，sku级别
	 */
	private String needDeliveryTime;

}
