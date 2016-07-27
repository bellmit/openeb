package com.gsccs.eb.api.domain.goods;

import java.util.List;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 商品sku对象
 * 
 * @author x.d zhang
 * 
 */
public class AuctionSkuDO extends Domain {

	private static final long serialVersionUID = 3358862828146538635L;

	/**
	 * sku描述信息
	 */
	private String description;

	/**
	 * 商品宝贝id
	 */
	private Long itemId;

	/**
	 * sku对应外部编码
	 */
	private String outerId;

	/**
	 * sku价格，以分为单位
	 */
	private Long price;

	/**
	 * sku的属性及属性值id
	 */
	private String properties;

	/**
	 * sku包含的属性对列表
	 */
	private List<AuctionPVPairDO> pvList;

	/**
	 * sku的库存
	 */
	private Long quantity;

	/**
	 * sku_id
	 */
	private Long skuId;

	/**
	 * 状态 1：正常 -1：删除
	 */
	private Long status;

}
