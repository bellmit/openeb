package com.gsccs.eb.api.domain.site;

/**
 * 站点导航
 * @author x.d zhang
 *
 */
public class Navigation {
	
	private String id;
	private String title;
	private String url;
	private Long shopid;
	private Long cateid;
	private Integer ordernum;
	private String blank;
	private String hidden;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Long getCateid() {
		return cateid;
	}

	public void setCateid(Long cateid) {
		this.cateid = cateid;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

}