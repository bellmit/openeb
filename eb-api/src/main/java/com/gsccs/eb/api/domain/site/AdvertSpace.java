package com.gsccs.eb.api.domain.site;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 广告位对象
 * 
 * @author x.d zhang
 * 
 */
public class AdvertSpace extends Domain {

	private Long id;
	private String title;

	private String apclass;
	private String apdisplay;
	private String apcode;
	private Float apwidth;
	private Float apheight;
	private String state;
	private Long shopid;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApclass() {
		return apclass;
	}

	public void setApclass(String apclass) {
		this.apclass = apclass;
	}

	public String getApdisplay() {
		return apdisplay;
	}

	public void setApdisplay(String apdisplay) {
		this.apdisplay = apdisplay;
	}

	public String getApcode() {
		return apcode;
	}

	public void setApcode(String apcode) {
		this.apcode = apcode;
	}

	public Float getApwidth() {
		return apwidth;
	}

	public void setApwidth(Float apwidth) {
		this.apwidth = apwidth;
	}

	public Float getApheight() {
		return apheight;
	}

	public void setApheight(Float apheight) {
		this.apheight = apheight;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}