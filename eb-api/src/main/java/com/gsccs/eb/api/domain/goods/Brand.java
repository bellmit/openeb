package com.gsccs.eb.api.domain.goods;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 品牌
 * 
 * @author x.d zhang
 * 
 */
public class Brand extends Domain {

	private static final long serialVersionUID = 3897573635852722321L;

	private Long id;
	private String name;
	private Integer ordernum;
	private Integer clicknum;
	private String templet;
	private String content;
	private String state;
	private Long shopid;

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
		this.name = name;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getTemplet() {
		return templet;
	}

	public void setTemplet(String templet) {
		this.templet = templet;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

}
