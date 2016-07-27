package com.gsccs.b2c.plat.common.model;

import org.apache.solr.client.solrj.beans.Field;


/**
 * 
 * @author x.d zhang
 *
 */
public class TestGoods {
	
	@Field
	private Long id;
	@Field
	private String title;
	@Field
	private String brandId;
	@Field
	private String[] cat;
	@Field
	private String[] features;
	@Field
	private Float price;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String[] getCat() {
		return cat;
	}

	public void setCat(String[] cat) {
		this.cat = cat;
	}

	public String[] getFeatures() {
		return features;
	}

	public void setFeatures(String[] features) {
		this.features = features;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	

}
