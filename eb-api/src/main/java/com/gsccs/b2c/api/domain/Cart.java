package com.gsccs.b2c.api.domain;

/**
 * 购物车
 * @author ZhangTao
 *
 */
public class Cart extends DomainObject {

	private static final long serialVersionUID = 1L;

	/**
	 * 购物车ID
	 */
	//private Long id;
	private String id;
	
	/**
	 * 产品ID
	 */
	private Long pid;
	
	/**
	 * SKU ID 
	 */
	private Long skuid;
	
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
	private int number;

	/**
	 * 合计价格
	 */
	private Double amount;

	public String getId() {
		//System.out.println("PID:"+getPid()+"SKUID:"+getSkuid());
		if (null != getPid() && null != getSkuid()){
			id = getPid()+"_"+getSkuid();
		}
		if (null != getPid()){
			id = getPid()+"";
		}
		return id;
	}

	/*public void setId(Long id) {
		this.id = id;
	}*/

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Double getAmount() {
		amount = this.price*this.number;
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = this.price*this.number;
	//amount;
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
	
	
	
}
