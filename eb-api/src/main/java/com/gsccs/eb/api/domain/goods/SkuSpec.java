package com.gsccs.eb.api.domain.goods;

import com.gsccs.b2c.api.domain.Domain;

/**
 * SKU 规格
 * 
 * @author x.d zhang
 * 
 */
public class SkuSpec extends Domain {

	private Long id;
	private Long specid;
	private Long specvalid;
	private Long productid;
	private Long skuid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSpecid() {
		return specid;
	}

	public void setSpecid(Long specid) {
		this.specid = specid;
	}

	public Long getSpecvalid() {
		return specvalid;
	}

	public void setSpecvalid(Long specvalid) {
		this.specvalid = specvalid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Long getSkuid() {
		return skuid;
	}

	public void setSkuid(Long skuid) {
		this.skuid = skuid;
	}

}
