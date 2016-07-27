package com.gsccs.b2c.api.domain;

/**
 * 库存明细
 * 
 * @author x.d zhang
 * 
 */
public class InventoryDetailDo extends DomainObject {

	private static final long serialVersionUID = 4693382126213166784L;

	/**
	 * 主订单号
	 */
	private Long bizOrderId;

	/**
	 * 子订单号
	 */
	private Long bizSubOrderId;

	/**
	 * 1拍减 2付减
	 */
	private Long flag;

	/**
	 * 占用数量
	 */
	private Long occupyQuantity;

	/**
	 * 货主昵称
	 */
	private String ownerNick;

	/**
	 * 预扣库存数
	 */
	private Long reserveQuantity;

	/**
	 * 仓储商品id
	 */
	private Long scItemId;

	/**
	 * 仓库编码
	 */
	private String storeCode;

}
