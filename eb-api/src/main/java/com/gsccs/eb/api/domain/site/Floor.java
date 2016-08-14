package com.gsccs.eb.api.domain.site;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 商城单个楼层对象
 * 
 * @author x.d zhang
 * 
 */
public class Floor extends Domain {

	private String id;
	private String title;
	private String subtitle;
	// 主题图
	private String themeimg;
	// 导航图
	private String banneimg;

	private String state;
	private Long shopid;
	private Integer ordernum = 0;
	private String goodids;
	private String cateids;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThemeimg() {
		return themeimg;
	}

	public void setThemeimg(String themeimg) {
		this.themeimg = themeimg;
	}

	public String getBanneimg() {
		return banneimg;
	}

	public void setBanneimg(String banneimg) {
		this.banneimg = banneimg;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getGoodids() {
		return goodids;
	}

	public void setGoodids(String goodids) {
		this.goodids = goodids;
	}

	public String getCateids() {
		return cateids;
	}

	public void setCateids(String cateids) {
		this.cateids = cateids;
	}

}