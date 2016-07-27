package com.gsccs.b2c.api.domain;

import java.util.Date;
import java.util.List;

/**
 * 商品结构
 * 
 * @author x.d zhang
 * 
 */
public class Goods extends DomainObject {

	private static final long serialVersionUID = 1221633842353432629L;

	/**
	 * 商品级别的条形码
	 */
	private String barcode;

	/**
	 * 商品的子标题，给商品增加卖点等描述
	 */
	private String subTitle;

	/**
	 * 商品标题,不能超过60字节
	 */
	private String title;

	/**
	 * 商品数量
	 */
	private Long num;

	/**
	 * 商品价格，格式：5.00；单位：元；精确到：分
	 */
	private Double price;

	/**
	 * 所属产品的id
	 */
	private Long productId;

	/**
	 * Item的发布时间
	 */
	private Date created;

	/**
	 * 上架时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	private Date listTime;

	/**
	 * 商品修改时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	private Date modified;

	/**
	 * 
	 * Sku列表。fields中只设置sku可以返回Sku结构体中所有字段，如果设置为sku.sku_id、sku.properties、sku.
	 * quantity等形式就只会返回相应的字段
	 */
	private List<Sku> skus;

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getListTime() {
		return listTime;
	}

	public void setListTime(Date listTime) {
		this.listTime = listTime;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}

}
