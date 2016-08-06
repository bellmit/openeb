package com.gsccs.b2c.api.domain;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 商品库存对象
 * 
 * @author x.d zhang
 * 
 */
public class InventorySum extends Domain {
	
	
	private static final long serialVersionUID = 6139976869269869221L;

	/**
	 * 库存类型： 1：正常 2：损坏 3：冻结 10：质押 11-20:商家自定义
	 */
	private Long inventoryType;

	/**
	 * 库存类型名称
	 */
	private String inventoryTypeName;

	/**
	 * 总占用数量
	 */
	private Long occupyQuantity;

	/**
	 * 总物理库存数量
	 */
	private Long quantity;

	/**
	 * 总预扣数量
	 */
	private Long reserveQuantity;

	/**
	 * 商品商家编码
	 */
	private String scItemCode;

	/**
	 * 商品后端ID，如果有传sc_item_code,参数可以为0
	 */
	private Long scItemId;

	/**
	 * 商家仓库编码
	 */
	private String storeCode;

}
