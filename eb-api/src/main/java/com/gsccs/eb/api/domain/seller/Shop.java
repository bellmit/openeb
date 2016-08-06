package com.gsccs.eb.api.domain.seller;

import java.util.Date;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 店铺对象
 * 
 * @创建人： niu x.j
 * @类名称：Store
 * @创建时间：2015年3月18日 下午3:39:51
 * 
 */
public class Shop extends Domain {

	private Long id;
	// 商店名称
	private String name;
	private String adress;
	private String phone;
	private String email;
	// 店铺域名
	private String domain;
	// 店铺path
	private String sitepath;
	public String gradeid;
	public String state;
	// 店铺商品库存预警值
	private Integer stockalertnum;

	private Date addtime;
	private String status;
	// 商城管理员帐户
	private String account;
	private String password;

	private String addtimestr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress == null ? null : adress.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSitepath() {
		return sitepath;
	}

	public void setSitepath(String sitepath) {
		this.sitepath = sitepath;
	}

	public String getGradeid() {
		return gradeid;
	}

	public void setGradeid(String gradeid) {
		this.gradeid = gradeid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getStockalertnum() {
		return stockalertnum;
	}

	public void setStockalertnum(Integer stockalertnum) {
		this.stockalertnum = stockalertnum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getAddtimestr() {
		return addtimestr;
	}

	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}