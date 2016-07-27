package com.gsccs.b2c.api.domain;

/**
 * 收货人详细信息
 * 
 * @author x.d zhang
 * 
 */
public class Receiver extends DomainObject {

	private static final long serialVersionUID = 7184163116171493652L;

	/**
	 * 收货人的详细地址信息
	 */
	private String address;

	/**
	 * 证件号
	 */
	private String cardId;

	/**
	 * 收货人的城市
	 */
	private String city;

	/**
	 * 区/县
	 */
	private String district;

	/**
	 * 移动电话。
	 */
	private String mobilePhone;

	/**
	 * 收货人全名。
	 */
	private String name;

	/**
	 * 固定电话。
	 */
	private String phone;

	/**
	 * 收货人所在省份
	 */
	private String state;

	/**
	 * 邮政编码
	 */
	private String zip;
}
