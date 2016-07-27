package com.gsccs.b2c.api.domain;

/**
 * 交易扩展表信息
 * @author x.d zhang
 *
 */
public class TradeExt extends DomainObject {
	
	private static final long serialVersionUID = 7134589894948337398L;

	/**
	 * 关闭订单前扩展标识位
	 */
	private Long beforeCloseFlag;

	/**
	 * 确认收货前扩展标识位
	 */
	private Long beforeConfirmFlag;

	/**
	 * enable前扩展标识位
	 */
	private Long beforeEnableFlag;

	/**
	 * 修改前扩展标识位
	 */
	private Long beforeModifyFlag;

	/**
	 * 付款前扩展标识位
	 */
	private Long beforePayFlag;

	/**
	 * 评价前扩展标识位
	 */
	private Long beforeRateFlag;

	/**
	 * 退款前扩展标识位
	 */
	private Long beforeRefundFlag;

	/**
	 * 发货前扩展标识位
	 */
	private Long beforeShipFlag;

	/**
	 * attributes标记
	 */
	private String extAttributes;

	/**
	 * 第三方个性化数据
	 */
	private String extraData;

	/**
	 * 第三方状态，第三方自由定义
	 */
	private Long thirdPartyStatus;

}
