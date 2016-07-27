package com.gsccs.b2c.plat.shop.model;

/**
 * 
 * @author x.d zhang
 *
 */
public class CategoryT {

	private Long id;
	private Long parid;
	private String parids;
	private String title;
	private Long typeId;
	private String logo;
	private String templet;
	private String url;
	private String state;
	private Integer clicknum;
	private String pagemark;
	private Integer indexnum;
	private String metaTitle;
	private String metaKeywords;
	private String metaDescr;
	
	//类型名称
	private String typename;
	
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
		this.title = title == null ? null : title.trim();
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
		this.logo = logo == null ? null : logo.trim();
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
		this.templet = templet == null ? null : templet.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
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
		this.pagemark = pagemark == null ? null : pagemark.trim();
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
		this.metaTitle = metaTitle == null ? null : metaTitle.trim();
	}

	public String getMetaKeywords() {
		return metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords == null ? null : metaKeywords.trim();
	}

	public String getMetaDescr() {
		return metaDescr;
	}

	public void setMetaDescr(String metaDescr) {
		this.metaDescr = metaDescr == null ? null : metaDescr.trim();
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
}