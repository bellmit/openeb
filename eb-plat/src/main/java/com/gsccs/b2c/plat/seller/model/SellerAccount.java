package com.gsccs.b2c.plat.seller.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SellerAccount {

	private Long id;
	private String account;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private Long storeId;
	private Date addDate;
	private Date loginDate;
	private String state = "1";
	private String salt;
	
	private String adddatestr;
	private String storename;

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getAdddatestr() {
		if (null != getAddDate()){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			adddatestr = df.format(getAddDate()); 
		}
		return adddatestr;
	}

	public void setAdddatestr(String adddatestr) {
		this.adddatestr = adddatestr;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getCredentialsSalt() {
		return account + salt;
	}
}