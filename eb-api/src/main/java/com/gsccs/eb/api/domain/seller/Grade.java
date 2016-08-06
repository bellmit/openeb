package com.gsccs.eb.api.domain.seller;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 商铺等级
 * @author x.d zhang
 *
 */
public class Grade extends Domain{

	private Integer id;
	private String title;
	private Integer goodsLimit;
	private Integer albumLimit;
	private String description;
	private Integer sgGrade;
	private Integer sgPrice;
	private Integer brokerageScale;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getGoodsLimit() {
		return goodsLimit;
	}

	public void setGoodsLimit(Integer goodsLimit) {
		this.goodsLimit = goodsLimit;
	}

	public Integer getAlbumLimit() {
		return albumLimit;
	}

	public void setAlbumLimit(Integer albumLimit) {
		this.albumLimit = albumLimit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSgGrade() {
		return sgGrade;
	}

	public void setSgGrade(Integer sgGrade) {
		this.sgGrade = sgGrade;
	}

	public Integer getSgPrice() {
		return sgPrice;
	}

	public void setSgPrice(Integer sgPrice) {
		this.sgPrice = sgPrice;
	}

	public Integer getBrokerageScale() {
		return brokerageScale;
	}

	public void setBrokerageScale(Integer brokerageScale) {
		this.brokerageScale = brokerageScale;
	}

}