package com.gsccs.b2c.api.domain;

/**
 * 地址对象
 * 
 * @author x.d zhang
 * 
 */
public class Location extends DomainObject {

	private static final long serialVersionUID = 1179624343648523626L;

	/**
	 * 国家名称
	 */
	private String country;
	/**
	 * 所在省份（中文名称）
	 */
	private String state;

	/**
	 * 所在城市（中文名称）
	 */
	private String city;

	/**
	 * 区/县（只适用于物流API）
	 */
	private String district;

	/**
	 * 详细地址，最大256个字节（128个中文）
	 */
	private String address;

	/**
	 * 邮政编码
	 */
	private String zip;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
