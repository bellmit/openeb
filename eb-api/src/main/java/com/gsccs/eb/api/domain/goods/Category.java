package com.gsccs.eb.api.domain.goods;

import java.util.List;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 类目列表，多级结构
 * 
 * @author x.d zhang
 * 
 */
public class Category extends Domain {

	/**
	 * 类目id
	 */
	private Long id;

	/**
	 * 类目名称
	 */
	private String title;
	/*
	 * 类型Id
	 */
	private Long typeId;
	private Long shopId;
	private String logo;
	private Long parid;
	private String parids;
	private String templet;
	private String url;
	private String state;
	private Integer ordernum;
	private Integer clicknum;
	private String pagemark;
	private Integer indexnum;
	private String metaTitle;
	private String metaKeywords;
	private String metaDescr;

	private String typename;

	private List<Category> subCategory;

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

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getParid() {
		return parid;
	}

	public void setParid(Long parid) {
		this.parid = parid;
	}

	public String getParids() {
		return parids;
	}

	public void setParids(String parids) {
		this.parids = parids;
	}

	public String getTemplet() {
		return templet;
	}

	public void setTemplet(String templet) {
		this.templet = templet;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getPagemark() {
		return pagemark;
	}

	public void setPagemark(String pagemark) {
		this.pagemark = pagemark;
	}

	public Integer getIndexnum() {
		return indexnum;
	}

	public void setIndexnum(Integer indexnum) {
		this.indexnum = indexnum;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDescr() {
		return metaDescr;
	}

	public void setMetaDescr(String metaDescr) {
		this.metaDescr = metaDescr;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public List<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}

}
