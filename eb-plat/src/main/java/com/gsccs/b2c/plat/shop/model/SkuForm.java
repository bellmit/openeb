package com.gsccs.b2c.plat.shop.model;

public class SkuForm {

	private String skuid;
	private String serial;
	private String specName;
	private Float price;
	private Integer storenum;
	private String specvals;
	private String specIsOpen;

	public String getSkuid() {
		return skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStorenum() {
		return storenum;
	}

	public void setStorenum(Integer storenum) {
		this.storenum = storenum;
	}

	public String getSpecvals() {
		return specvals;
	}

	public void setSpecvals(String specvals) {
		this.specvals = specvals;
	}

	public String getSpecIsOpen() {
		return specIsOpen;
	}

	public void setSpecIsOpen(String specIsOpen) {
		this.specIsOpen = specIsOpen;
	}

}
