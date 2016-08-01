package com.gsccs.b2c.plat.site.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 访问记录
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
public class Visit {

	private String id;
	private String storename;
	private String catename;
	private String goodsname;
	private Integer countnum;
	private Date starttime;
	private Date endtime;
	private String starttimeStr;
	private String endtimeStr;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String statType;
	private String datename;

	private String storeid;
	private String cateid;
	private String goodsid;
	private String url;
	private Date addtime;
	private String ip;

	// 搜索关键词
	private String key;
	// 会员ID
	private String mmid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public Integer getCountnum() {
		return countnum;
	}

	public void setCountnum(Integer countnum) {
		this.countnum = countnum;
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

	public String getStarttimeStr() {
		if (starttime != null) {
			starttimeStr = sdf.format(starttime);
		}
		return starttimeStr;
	}

	public void setStarttimeStr(String starttimeStr) {
		this.starttimeStr = starttimeStr;
	}

	public String getEndtimeStr() {
		if (endtime != null) {
			endtimeStr = sdf.format(endtime);
		}
		return endtimeStr;
	}

	public void setEndtimeStr(String endtimeStr) {
		this.endtimeStr = endtimeStr;
	}

	public String getStatType() {
		return statType;
	}

	public void setStatType(String statType) {
		this.statType = statType;
	}

	public String getDatename() {
		return datename;
	}

	public void setDatename(String datename) {
		this.datename = datename;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

}