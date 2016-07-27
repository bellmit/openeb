package com.gsccs.b2c.api.domain;

/**
 * sku中所包含的属性对
 * 
 * @author x.d zhang
 * 
 */
public class AuctionPVPairDO extends DomainObject {

	private static final long serialVersionUID = 8453164223432221239L;

	/**
	 * 类目销售属性id
	 */
	private Long propertyId;

	/**
	 * 类目属性名称
	 */
	private String propertyText;

	/**
	 * sku属性对状态值
	 */
	private Long status;

	/**
	 * 类目属性值id
	 */
	private Long valueId;

	/**
	 * 类目属性值名称
	 */
	private String valueText;

}
