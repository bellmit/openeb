package com.gsccs.b2c.plat.shop.model;

/**
 * 商城类目
 * @author x.d zhang
 *
 */
public class StoreCate {
	
	private Long siteId;
	private String cateids;
	private String brandids;
	
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getCateids() {
		return cateids;
	}

	public void setCateids(String cateids) {
		this.cateids = cateids == null ? null : cateids.trim();
	}

	public String getBrandids() {
		return brandids;
	}

	public void setBrandids_(String brandids) {
		this.brandids = brandids;
	}
	
	
}