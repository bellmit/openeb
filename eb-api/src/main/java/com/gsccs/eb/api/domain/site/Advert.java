package com.gsccs.eb.api.domain.site;

import java.util.Date;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 广告对象
 * 
 * @author x.d zhang
 * 
 */
public class Advert extends Domain {

	private Long id;
	private Long shopid;
	private Long spaceid;
	private String title;
	private String advurl;
	private String advimg;
	private Date starttime;
	private Date endtime;
	private Integer ordernum;

	private String spacetitle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Long getSpaceid() {
		return spaceid;
	}

	public void setSpaceid(Long spaceid) {
		this.spaceid = spaceid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAdvurl() {
		return advurl;
	}

	public void setAdvurl(String advurl) {
		this.advurl = advurl;
	}

	public String getAdvimg() {
		return advimg;
	}

	public void setAdvimg(String advimg) {
		this.advimg = advimg;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getSpacetitle() {
		return spacetitle;
	}

	public void setSpacetitle(String spacetitle) {
		this.spacetitle = spacetitle;
	}

}