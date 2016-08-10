package com.gsccs.b2c.plat.buyer.model;

import java.math.BigDecimal;

public class Discount {

	private Long id;

	private Long shopid;
	private Long goodsId;
	private Long levelId;
	private Float disCount;
	private BigDecimal price;

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

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public Float getDisCount() {
		return disCount;
	}

	public void setDisCount(Float disCount) {
		this.disCount = disCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}