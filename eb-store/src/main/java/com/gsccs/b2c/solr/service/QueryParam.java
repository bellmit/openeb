package com.gsccs.b2c.solr.service;

/**
 * 查询参数
 * 
 * @author x.d zhang
 * 
 */
public class QueryParam {

	private String siteId;
	private String keyword;
	private String cateId;
	private String brandIds[];
	private String[] attrIds;
	private String[] attrValIds;
	private Integer minPrice;
	private Integer maxPrice;

	// 分页参数
	private int page;
	private int rows;

	private String order = "score desc";

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String[] getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(String[] brandIds) {
		this.brandIds = brandIds;
	}

	public String[] getAttrIds() {
		return attrIds;
	}

	public void setAttrIds(String[] attrIds) {
		this.attrIds = attrIds;
	}

	public String[] getAttrValIds() {
		return attrValIds;
	}

	public void setAttrValIds(String[] attrValIds) {
		this.attrValIds = attrValIds;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return (getPage() - 1) * getRows();
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
