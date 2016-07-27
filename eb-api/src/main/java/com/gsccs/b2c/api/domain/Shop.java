package com.gsccs.b2c.api.domain;

import java.util.Date;

/**
 * 店铺信息
 * 
 * @author x.d zhang
 * 
 */
public class Shop extends DomainObject {

	//private static final long serialVersionUID = 8567396925328831457L;

	/**
	 * 店铺编号。
	 */
	private Long sid;

	/**
	 * 店铺公告
	 */
	private String bulletin;

	/**
	 * 店铺所属的类目编号
	 */
	private Long cid;

	/**
	 * 开店时间。格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date created;

	/**
	 * 店铺描述
	 */
	private String desc;

	/**
	 * 最后修改时间。格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date modified;

	/**
	 * 卖家昵称
	 */
	private String nick;

	/**
	 * 店标地址。
	 */
	private String picPath;

	/**
	 * 店铺标题
	 */
	private String title;
	
	/**
	 * shop.domain.com即店铺地址
	 */
	private String domain="http://localhost:9080/eb-site/1001/";
	
	/**
	 * 资源域名
	 */
	private String imgDomain;
	
	private Integer stockalertnum;
	
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getBulletin() {
		return bulletin;
	}

	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getImgDomain() {
		return imgDomain;
	}

	public void setImgDomain(String imgDomain) {
		this.imgDomain = imgDomain;
	}

	public Integer getStockalertnum() {
		return stockalertnum;
	}

	public void setStockalertnum(Integer stockalertnum) {
		this.stockalertnum = stockalertnum;
	}

}
