package com.gsccs.b2c.api.domain;

/**
 * SKU 规格
 * @author x.d zhang
 *
 */
public class SkuSpec extends DomainObject {

	private Long specId;
	private Long specValId;
	private String specTitle;
	private String specVal;

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public Long getSpecValId() {
		return specValId;
	}

	public void setSpecValId(Long specValId) {
		this.specValId = specValId;
	}

	public String getSpecTitle() {
		return specTitle;
	}

	public void setSpecTitle(String specTitle) {
		this.specTitle = specTitle;
	}

	public String getSpecVal() {
		return specVal;
	}

	public void setSpecVal(String specVal) {
		this.specVal = specVal;
	}

}
