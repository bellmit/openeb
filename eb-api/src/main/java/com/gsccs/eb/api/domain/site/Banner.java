package com.gsccs.eb.api.domain.site;

/**
 * 商城Banner
 * 
 * @author x.d zhang
 * 
 */
public class Banner {

	private String id;
	private String title;
	private String imgurl;
	private String link;
	private String type;
	private Long siteid;
	private Integer ordernum;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public void setId(String id) {
		this.id = id;
	}

}