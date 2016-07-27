package com.gsccs.b2c.plat.shop.model;

public class GoodsT {
	private Long id;
	private Long pid;
	private String barcode;
	private String title;
	private String specids;
	private String specstr;
	private Double price;
	// 库存量
	private Integer storenum;
	// 锁定库存
	private Integer locknum;
	// 销量
	private Integer salenum;
	// 状态
	private String status;
	/**
	 * 产品的市场价格
	 */
	private Double mkprice;

	/**
	 * 产品的成本价格
	 */
	private Double cost;

	/**
	 * 商品的重量，用于按重量计费的运费模板。注意：单位为kg
	 */
	private String goodsWeight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode == null ? null : barcode.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSpecids() {
		return specids;
	}

	public void setSpecids(String specids) {
		this.specids = specids;
	}

	public String getSpecstr() {
		return specstr;
	}

	public void setSpecstr(String specstr) {
		this.specstr = specstr;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStorenum() {
		return storenum;
	}

	public void setStorenum(Integer storenum) {
		this.storenum = storenum;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public Double getMkprice() {
		return mkprice;
	}

	public void setMkprice(Double mkprice) {
		this.mkprice = mkprice;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}