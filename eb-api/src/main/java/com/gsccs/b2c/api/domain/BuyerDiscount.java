package com.gsccs.b2c.api.domain;

/**
 * 会员等级折扣信息
 * 
 * @author x.d zhang
 * 
 */
public class BuyerDiscount extends DomainObject {

	
	private static final long serialVersionUID = 6629334199677469213L;

	/**
	 * 创建时间
	 */
	private Long id;

	/**
	 * 产品ID
	 */
	private Long productId;

	/**
	 * 商品ID
	 */
	private Long goodsId;

	/**
	 * 折扣名称
	 */
	private Long siteId;

	/**
	 * 会员等级ID
	 */
	private Long levelId;

	/**
	 * 会员等级名称
	 */
	private String levelName;

	/**
	 * 折扣率
	 */
	private Float disCount;

	/**
	 * 价格
	 */
	private Double price;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Float getDisCount() {
		return disCount;
	}

	public void setDisCount(Float disCount) {
		this.disCount = disCount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
