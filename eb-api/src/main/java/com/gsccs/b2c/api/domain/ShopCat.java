package com.gsccs.b2c.api.domain;

/**
 * 店铺类目
 * @author x.d zhang
 *
 */
public class ShopCat extends DomainObject {

	private static final long serialVersionUID = 5625927693244496952L;

	/**
	 * 类目编号
	 */
	private Long cid;

	/**
	 * 该类目是否为父类目。即：该类目是否还有子类目
	 */
	private Boolean isParent;

	/**
	 * 类目名称
	 */
	private String name;

	/**
	 * 父类目编号，注：此类目指前台类目，值等于0：表示此类目为一级类目，值不等于0：表示此类目有父类目
	 */
	private Long parentCid;
}
