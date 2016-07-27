package com.gsccs.eb.api.domain.trade;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 退款详情
 * @author x.d zhang
 *
 */
public class Refund extends Domain {

	private static final long serialVersionUID = 4886549173422454298L;
	
	/**
	 * 交易号
	 */
	private String orderNo;
	
	/**
	 * 卖家收货地址
	 */
	private String address;

	/**
	 * 退款先行垫付默认的未申请状态 0;退款先行垫付申请中  1;退款先行垫付，垫付完成 2;退款先行垫付，卖家拒绝收货 3;退款先行垫付，垫付关闭 4;退款先行垫付，垫付分账成功 5;
	 */
	private Long advanceStatus;

	

	/**
	 * 退款扩展属性
	 */
	private String attribute;

	/**
	 * 买家昵称
	 */
	private String buyerNick;

	/**
	 * 物流公司名称
	 */
	private String companyName;

	/**
	 * 退款申请时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date created;

	/**
	 * 不需客服介入1;需要客服介入2;客服已经介入3;客服初审完成 4;客服主管复审失败5;客服处理完成6;
	 */
	private Long csStatus;

	/**
	 * 退款说明
	 */
	private String desc;

	/**
	 * 退货时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date goodReturnTime;

	/**
	 * 货物状态。可选值BUYER_NOT_RECEIVED (买家未收到货) BUYER_RECEIVED (买家已收到货) BUYER_RETURNED_GOODS (买家已退货)
	 */
	private String goodStatus;

	/**
	 * 买家是否需要退货。可选值:true(是),false(否)
	 */
	private Boolean hasGoodReturn;

	/**
	 * 申请退款的商品字符串编号(注意：iid近期即将废弃，请用num_iid参数)
	 */
	private String iid;

	/**
	 * 更新时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date modified;

	/**
	 * 商品购买数量
	 */
	private Long num;

	/**
	 * 申请退款的商品数字编号
	 */
	private Long numIid;

	/**
	 * 子订单号。如果是单笔交易oid会等于tid
	 */
	private Long oid;

	/**
	 * 退款约束，可选值：cannot_refuse（不允许操作），refund_onweb（需要到网页版操作）
	 */
	private String operationContraint;

	/**
	 * 退款对应的订单交易状态。可选值TRADE_NO_CREATE_PAY(没有创建支付宝交易) WAIT_BUYER_PAY(等待买家付款) WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款) WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货) TRADE_BUYER_SIGNED(买家已签收,货到付款专用) TRADE_FINISHED(交易成功) TRADE_CLOSED(交易关闭) ALL_WAIT_PAY(包含：WAIT_BUYER_PAY、TRADE_NO_CREATE_PAY) ALL_CLOSED(包含：TRADE_CLOSED) 
	 */
	private String orderStatus;

	/**
	 * 商品外部商家编码
	 */
	private String outerId;

	/**
	 * 支付给卖家的金额(交易总金额-退还给买家的金额)。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String payment;

	/**
	 * 商品价格。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String price;

	/**
	 * 退款原因
	 */
	private String reason;

	/**
	 * 退还金额(退还给买家的金额)。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String refundFee;

	/**
	 * 退款单号
	 */
	private Long refundId;

	/**
	 * 退款阶段，可选值：onsale/aftersale
	 */
	private String refundPhase;

	/**
	 * 退款超时结构RefundRemindTimeout
	 */
	private RefundRemindTimeout refundRemindTimeout;

	/**
	 * 退款版本号（时间戳）
	 */
	private Long refundVersion;

	/**
	 * 卖家昵称
	 */
	private String sellerNick;

	/**
	 * 物流方式.可选值:free(卖家包邮),post(平邮),express(快递),ems(EMS).
	 */
	private String shippingType;

	/**
	 * 退货运单号
	 */
	private String sid;

	/**
	 * 商品SKU信息
	 */
	private String sku;

	/**
	 * 分账给卖家的钱
	 */
	private String splitSellerFee;

	/**
	 * 分账给平台的钱
	 */
	private String splitPlatFee;

	/**
	 * 退款状态。可选值WAIT_SELLER_AGREE(买家已经申请退款，等待卖家同意) WAIT_BUYER_RETURN_GOODS(卖家已经同意退款，等待买家退货) WAIT_SELLER_CONFIRM_GOODS(买家已经退货，等待卖家确认收货) SELLER_REFUSE_BUYER(卖家拒绝退款) CLOSED(退款关闭) SUCCESS(退款成功)
	 */
	private String status;

	/**
	 * 平台交易单号
	 */
	private Long tid;

	/**
	 * 商品标题
	 */
	private String title;

	/**
	 * 交易总金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String totalFee;
}
