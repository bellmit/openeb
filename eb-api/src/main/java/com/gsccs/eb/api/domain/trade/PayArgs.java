package com.gsccs.eb.api.domain.trade;

import com.gsccs.eb.api.domain.base.Domain;

public class PayArgs extends Domain{

	private String id;
	private String typeid;
	private String appid;
	private String appkey;
	private String signtype;
	private String email;
	private Long shopid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

}