package com.gsccs.eb.api.domain.buyer;

import com.gsccs.b2c.api.domain.Domain;

/**
 * @说明 API---会员收货地址
 * @开发者 ma hong
 * @年月日 2015年4月14日
 * @时分秒 下午3:57:47
 */
public class BuyerDeliver extends Domain {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String region; // 所以地区
	private String details; // 详细地址
	private String zipcode; // 邮政编码
	private String receiver; // 收货人姓名
	private String mobile; // 手机号码
	private String telephone; // 电话号码
	private String email;		//邮箱地址
	private String isdefault; // 是否设置为默认地址
	private Long buyerid; 	// 会员ID

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * ==========================================================================
	 * =========
	 */
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region == null ? null : region.trim();
	}

	/*
	 * ==========================================================================
	 * =========
	 */
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details == null ? null : details.trim();
	}

	/*
	 * ==========================================================================
	 * =========
	 */
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode == null ? null : zipcode.trim();
	}

	/*
	 * ==========================================================================
	 * =========
	 */
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver == null ? null : receiver.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobilephone(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	/*
	 * ==========================================================================
	 * =========
	 */
	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault == null ? null : isdefault.trim();
	}

	public Long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
