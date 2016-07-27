package com.gsccs.b2c.api.domain;

/**
 * 更新SKU价格时候的SKU价格对象
 * 
 * @author x.d zhang
 * 
 */
public class UpdateSkuPrice extends DomainObject {

	private static final long serialVersionUID = 5351444898279365979L;

	/**
	 * Sku的商家外部id
	 */
	private String outerId;

	/**
	 * 属于这个sku的商品的价格 取值范围:0-100000000;精确到2位小数;单位:元。如:200.07，表示:200元7分。
	 */
	private String price;

	/**
	 * Sku属性串。格式:pid:vid;pid:vid,如:
	 * 1627207:3232483;1630696:3284570,表示机身颜色:军绿色;手机套餐:一电一充
	 */
	private String properties;

	/**
	 * SkuID
	 */
	private Long skuId;

}
