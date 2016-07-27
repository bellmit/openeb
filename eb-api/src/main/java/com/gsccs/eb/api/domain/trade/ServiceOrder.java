package com.gsccs.eb.api.domain.trade;

import com.gsccs.b2c.api.domain.Domain;


/**
 * 商城虚拟服务子订单数据结构
 * @author x.d zhang
 *
 */
public class ServiceOrder extends Domain {

	private static final long serialVersionUID = 2387751422348796166L;

	/**
	 * 卖家昵称
	 */
	private String buyerNick;

	/**
	 * 服务所属的交易订单号。如果服务为一年包换，则item_oid这笔订单享受改服务的保护
	 */
	private Long itemOid;

	/**
	 * 购买数量，取值范围为大于0的整数
	 */
	private Long num;

	/**
	 * 虚拟服务子订单订单号
	 */
	private Long oid;

	/**
	 * 子订单实付金额。精确到2位小数，单位:元。如:200.07，表示:200元7分。
	 */
	private String payment;

	/**
	 * 服务图片地址
	 */
	private String picPath;

	/**
	 * 服务价格，精确到小数点后两位：单位:元
	 */
	private String price;

	/**
	 * 最近退款的id
	 */
	private Long refundId;

	/**
	 * 卖家昵称
	 */
	private String sellerNick;

	/**
	 * 服务详情的URL地址
	 */
	private String serviceDetailUrl;

	/**
	 * 服务数字id
	 */
	private Long serviceId;

	/**
	 * 商品名称
	 */
	private String title;

	/**
	 * 支持家装类物流的类型
	 */
	private String tmserSpuCode;

	/**
	 * 服务子订单总费用
	 */
	private String totalFee;
}
