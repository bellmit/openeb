package com.gsccs.eb.api.domain.trade;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 购物车条目
 * 
 * @author ZhangTao
 * 
 */
public class CartItem extends Domain {

	/**
	 * 购物车ID
	 */
	private Long id;
	//
	private String code;

	/**
	 * 产品ID
	 */
	private Long pid;

	/**
	 * SKU ID
	 */
	private Long skuid;

	private Long buyerid;

	/**
	 * 产品主图片路径
	 */
	private String picUrl;

	/**
	 * 产品描述
	 */
	private String desc;

	/**
	 * SKU信息
	 */
	private String sku;

	/**
	 * 产品市场价
	 */
	private Double mktPrice;

	/**
	 * 产品销售价
	 */
	private Double price;

	/**
	 * 购买数量
	 */
	private int num;

	private Long shopid;
	private Date addtime;
	private String state;

	/**
	 * 合计价格
	 */
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		// System.out.println("PID:"+getPid()+"SKUID:"+getSkuid());
		if (null != getPid() && null != getSkuid()) {
			code = getPid() + "_" + getSkuid();
		}
		if (null != getPid()) {
			code = getPid() + "";
		}
		return code;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Double getAmount() {
		amount = this.price * this.num;
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = this.price * this.num;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Double getMktPrice() {
		return mktPrice;
	}

	public void setMktPrice(Double mktPrice) {
		this.mktPrice = mktPrice;
	}

	public Long getSkuid() {
		return skuid;
	}

	public void setSkuid(Long skuid) {
		this.skuid = skuid;
	}

	public Long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
