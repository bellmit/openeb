package com.gsccs.eb.api.domain.trade;

import java.util.Date;
import java.util.List;

import com.gsccs.eb.api.domain.activity.PromotionDetail;
import com.gsccs.eb.api.domain.base.Domain;


/**
 * 交易结构
 * 
 * @author x.d zhang
 * 
 */
public class Trade extends Domain {
	
	private static final long serialVersionUID = 7548224479178422965L;

	/**
	 * 卖家手工调整金额，精确到2位小数，单位：元。如：200.07，表示：200元7分。来源于订单价格修改，如果有多笔子订单的时候，这个为0，
	 * 单笔的话则跟[order].adjust_fee一样
	 */
	private String adjustFee;


	/**
	 * 区域id，代表订单下单的区位码，区位码是通过省市区转换而来，通过区位码能精确到区内的划分，比如310012是杭州市西湖区华星路
	 */
	private String areaId;

	/**
	 * 物流到货时效截单时间，格式 HH:mm
	 */
	private String arriveCutTime;

	/**
	 * 物流到货时效，单位天
	 */
	private Long arriveInterval;

	/**
	 * 同步到卖家库的时间
	 */
	private Date asyncModified;

	/**
	 * 交易中剩余的确认收货金额（这个金额会随着子订单确认收货而不断减少，交易成功后会变为零）。精确到2位小数;单位:元。如:200.07，表示:200
	 * 元7分
	 */
	private String availableConfirmFee;

	/**
	 * 买家下单的地区
	 */
	private String buyerArea;

	/**
	 * 买家货到付款服务费。精确到2位小数;单位:元。如:12.07，表示:12元7分
	 */
	private String buyerCodFee;

	/**
	 * 买家邮件地址
	 */
	private String buyerEmail;


	/**
	 * 买家备注（与淘宝网上订单的买家备注对应，只有买家才能查看该字段）
	 */
	private String buyerMemo;

	/**
	 * 买家留言
	 */
	private String buyerMessage;

	/**
	 * 买家昵称
	 */
	private String buyerNick;

	/**
	 * 买家获得积分,返点的积分。格式:100;单位:个。返点的积分要交易成功之后才能获得。
	 */
	private Long buyerObtainPointFee;

	/**
	 * 买家是否已评价。可选值:true(已评价),false(未评价)。如买家只评价未打分，此字段仍返回false
	 */
	private Boolean buyerRate;

	/**
	 * 买家可以通过此字段查询是否当前交易可以评论，can_rate=true可以评价，false则不能评价。
	 */
	private Boolean canRate;

	/**
	 * 货到付款服务费。精确到2位小数;单位:元。如:12.07，表示:12元7分。
	 */
	private String codFee;

	/**
	 * 货到付款物流状态。 初始状态 NEW_CREATED, 接单成功 ACCEPTED_BY_COMPANY, 接单失败
	 * REJECTED_BY_COMPANY, 接单超时 RECIEVE_TIMEOUT, 揽收成功 TAKEN_IN_SUCCESS, 揽收失败
	 * TAKEN_IN_FAILED, 揽收超时 TAKEN_TIMEOUT, 签收成功 SIGN_IN, 签收失败
	 * REJECTED_BY_OTHER_SIDE, 订单等待发送给物流公司 WAITING_TO_BE_SENT, 用户取消物流订单 CANCELED
	 */
	private String codStatus;

	/**
	 * 交易佣金。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String commissionFee;

	/**
	 * 物流发货时效，单位小时
	 */
	private Long consignInterval;

	/**
	 * 卖家发货时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date consignTime;

	/**
	 * 交易创建时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date created;

	/**
	 * 使用信用卡支付金额数
	 */
	private String creditCardFee;

	/**
	 * 建议使用trade.promotion_details查询系统优惠
	 * 系统优惠金额（如打折，VIP，满就送等），精确到2位小数，单位：元。如：200.07，表示：200元7分
	 */
	private String discountFee;

	/**
	 * 交易结束时间。交易成功时间(更新交易状态为成功的同时更新)/确认收货时间或者交易关闭时间 。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date endTime;

	/**
	 * 电子凭证的垂直信息
	 */
	private String eticketExt;

	/**
	 * 快递代收款。精确到2位小数;单位:元。如:212.07，表示:212元7分
	 */
	private String expressAgencyFee;

	/**
	 * 判断订单是否有买家留言，有买家留言返回true，否则返回false
	 */
	private Boolean hasBuyerMessage;

	/**
	 * 是否包含邮费。与available_confirm_fee同时使用。可选值:true(包含),false(不包含)
	 */
	private Boolean hasPostFee;

	/**
	 * 订单中是否包含运费险订单，如果包含运费险订单返回true，不包含运费险订单，返回false
	 */
	private Boolean hasYfx;

	/**
	 * 出生日期
	 */
	private String hkBirthday;

	/**
	 * 证件号码
	 */
	private String hkCardCode;

	/**
	 * 证件类型 001代表港澳通行证类型、 002代表入台证 003代表护照
	 */
	private String hkCardType;

	/**
	 * 中文名
	 */
	private String hkChinaName;

	/**
	 * 拼音名
	 */
	private String hkEnName;

	/**
	 * 航班飞行时间
	 */
	private String hkFlightDate;

	/**
	 * 航班号
	 */
	private String hkFlightNo;

	/**
	 * 性别 M: 男性，F: 女性
	 */
	private String hkGender;

	/**
	 * 提货地点
	 */
	private String hkPickup;

	/**
	 * 提货地点id
	 */
	private String hkPickupId;

	/**
	 * 商品字符串编号(注意：iid近期即将废弃，请用num_iid参数)
	 */
	private String iid;

	/**
	 * 发票抬头
	 */
	private String invoiceName;

	/**
	 * 发票类型
	 */
	private String invoiceType;

	
	/**
	 * 表示是否是品牌特卖（常规特卖，不包括特卖惠和特实惠）订单，如果是返回true，如果不是返回false。
	 * 当此字段与is_force_wlb均为true时，订单强制物流宝发货。
	 */
	private Boolean isBrandSale;

	/**
	 * 表示订单交易是否含有对应的代销采购单。 如果该订单中存在一个对应的代销采购单，那么该值为true；反之，该值为false。
	 */
	private Boolean isDaixiao;

	

	/**
	 * 是否保障速递，如果为true，则为保障速递订单，使用线下联系发货接口发货，如果未false，则该订单非保障速递，
	 * 根据卖家设置的订单流转规则可使用物流宝或者常规物流发货。
	 */
	private Boolean isLgtype;

	/**
	 * 是否是多次发货的订单 如果卖家对订单进行多次发货，则为true 否则为false
	 */
	private Boolean isPartConsign;

	/**
	 * 表示订单交易是否网厅订单。 如果该订单是网厅订单，那么该值为true；反之，该值为false。
	 */
	private Boolean isWt;

	/**
	 * 次日达订单送达时间
	 */
	private String lgAging;

	/**
	 * 次日达，三日达等送达类型
	 */
	private String lgAgingType;

	/**
	 * 订单出现异常问题的时候，给予用户的描述,没有异常的时候，此值为空
	 */
	private String markDesc;

	/**
	 * 交易修改时间(用户对订单的任何修改都会更新此字段)。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date modified;

	/**
	 * 商品购买数量。取值范围：大于零的整数,对于一个trade对应多个order的时候（一笔主订单，对应多笔子订单），num=0，
	 * num是一个跟商品关联的属性，一笔订单对应多比子订单的时候，主订单上的num无意义。
	 */
	private Long num;

	/**
	 * 商品数字编号
	 */
	private Long numIid;

	/**
	 * 卡易售垂直表信息，去除下单ip之后的结果
	 */
	private String nutFeature;



	/**
	 * 导购员名称
	 */
	private String o2oGuideName;

	/**
	 * 外部订单号
	 */
	private String o2oOutTradeId;

	/**
	 * 导购员门店id
	 */
	private String o2oShopId;

	/**
	 * 导购门店名称
	 */
	private String o2oShopName;

	/**
	 * 订单列表
	 */
	private List<Order> orders;

	/**
	 * 付款时间。格式:yyyy-MM-dd HH:mm:ss。订单的付款时间即为物流订单的创建时间。
	 */
	private Date payTime;

	/**
	 * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String payment;

	/**
	 * 商品图片绝对途径
	 */
	private String picPath;

	/**
	 * 买家使用积分,下单时生成，且一直不变。格式:100;单位:个.
	 */
	private Long pointFee;

	/**
	 * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String postFee;

	/**
	 * 商品价格。精确到2位小数；单位：元。如：200.07，表示：200元7分
	 */
	private String price;

	/**
	 * 交易促销详细信息
	 */
	private String promotion;

	/**
	 * 优惠详情
	 */
	private List<PromotionDetail> promotionDetails;

	/**
	 * 买家实际使用积分（扣除部分退款使用的积分），交易完成后生成（交易成功或关闭），交易未完成时该字段值为0。格式:100;单位:个
	 */
	private Long realPointFee;

	/**
	 * 卖家实际收到的支付宝打款金额（由于子订单可以部分确认收货，这个金额会随着子订单的确认收货而不断增加，交易成功后等于买家实付款减去退款金额）。
	 * 精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String receivedPayment;

	/**
	 * 收货人的详细地址
	 */
	private String receiverAddress;

	/**
	 * 收货人的所在城市<br>
	 * 注：因为国家对于城市和地区的划分的有：省直辖市和省直辖县级行政区（区级别的）划分的，淘宝这边根据这个差异保存在不同字段里面
	 * 比如：广东广州：广州属于一个直辖市是放在的receiver_city的字段里面
	 * ；而河南济源：济源属于省直辖县级行政区划分，是区级别的，放在了receiver_district里面 <br>
	 * 建议：程序依赖于城市字段做物流等判断的操作，最好加一个判断逻辑：如果返回值里面只有receiver_district参数，该参数作为城市
	 */
	private String receiverCity;

	/**
	 * 收货人的所在地区<br>
	 * 注：因为国家对于城市和地区的划分的有：省直辖市和省直辖县级行政区（区级别的）划分的，淘宝这边根据这个差异保存在不同字段里面
	 * 比如：广东广州：广州属于一个直辖市是放在的receiver_city的字段里面
	 * ；而河南济源：济源属于省直辖县级行政区划分，是区级别的，放在了receiver_district里面 <br>
	 * 建议：程序依赖于城市字段做物流等判断的操作，最好加一个判断逻辑：如果返回值里面只有receiver_district参数，该参数作为城市
	 */
	private String receiverDistrict;

	/**
	 * 收货人的手机号码
	 */
	private String receiverMobile;

	/**
	 * 收货人的姓名
	 */
	private String receiverName;

	/**
	 * 收货人的电话号码
	 */
	private String receiverPhone;

	/**
	 * 收货人的所在省份
	 */
	private String receiverState;

	/**
	 * 收货人的邮编
	 */
	private String receiverZip;

	/**
	 * 卖家支付宝账号
	 */
	private String sellerAlipayNo;

	/**
	 * 卖家是否可以对订单进行评价
	 */
	private Boolean sellerCanRate;

	/**
	 * 卖家货到付款服务费。精确到2位小数;单位:元。如:12.07，表示:12元7分。卖家不承担服务费的订单：未发货的订单获取服务费为0，
	 * 发货后就能获取到正确值。
	 */
	private String sellerCodFee;

	/**
	 * 卖家邮件地址
	 */
	private String sellerEmail;

	

	/**
	 * 卖家备注（与网上订单的卖家备注对应，只有卖家才能查看该字段）
	 */
	private String sellerMemo;

	/**
	 * 卖家手机
	 */
	private String sellerMobile;

	/**
	 * 卖家姓名
	 */
	private String sellerName;

	/**
	 * 卖家昵称
	 */
	private String sellerNick;

	/**
	 * 卖家电话
	 */
	private String sellerPhone;

	/**
	 * 卖家是否已评价。可选值:true(已评价),false(未评价)
	 */
	private Boolean sellerRate;

	/**
	 * 订单将在此时间前发出，主要用于预售订单
	 */
	private String sendTime;

	/**
	 * 服务子订单列表
	 */
	private List<ServiceOrder> serviceOrders;



	/**
	 * 创建交易时的物流方式（交易完成前，物流方式有可能改变，但系统里的这个字段一直不变）。可选值：free(卖家包邮),post(平邮),express
	 * (快递),ems(EMS),virtual(虚拟发货)，25(次日必达)，26(预约配送)。
	 */
	private String shippingType;

	/**
	 * 交易快照详细信息
	 */
	private String snapshot;

	/**
	 * 交易快照地址
	 */
	private String snapshotUrl;

	/**
	 * 交易状态。可选值: TRADE_NO_CREATE_PAY(没有创建支付宝交易) WAIT_BUYER_PAY(等待买家付款)
	 * SELLER_CONSIGNED_PART(卖家部分发货) WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款)
	 * WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货)
	 * TRADE_BUYER_SIGNED(买家已签收,货到付款专用) TRADE_FINISHED(交易成功)
	 * PAY_PENDING(国际信用卡支付付款确认中) WAIT_PRE_AUTH_CONFIRM(0元购合约中)
	 */
	private String status;

	/**
	 * 分阶段付款的已付金额（万人团订单已付金额）
	 */
	private String stepPaidFee;

	/**
	 * 分阶段付款的订单状态（例如万人团订单等），目前有三返回状态
	 * FRONT_NOPAID_FINAL_NOPAID(定金未付尾款未付)，FRONT_PAID_FINAL_NOPAID
	 * (定金已付尾款未付)，FRONT_PAID_FINAL_PAID(定金和尾款都付)
	 */
	private String stepTradeStatus;

	/**
	 * 交易编号 (父订单的交易编号)
	 */
	private Long tid;

	/**
	 * 超时到期时间。格式:yyyy-MM-dd HH:mm:ss。业务规则： 前提条件：只有在买家已付款，卖家已发货的情况下才有效
	 * 如果申请了退款，那么超时会落在子订单上；比如说3笔ABC，A申请了，那么返回的是BC的列表, 主定单不存在
	 * 如果没有申请过退款，那么超时会挂在主定单上；比如ABC，返回主定单，ABC的超时和主定单相同
	 */
	private Date timeoutActionTime;

	/**
	 * 交易标题，以店铺名作为此标题的值。
	 */
	private String title;

	/**
	 * 商品金额（商品价格乘以数量的总金额）。精确到2位小数;单位:元。如:200.07，表示:200元7分
	 */
	private String totalFee;

	/**
	 * 交易扩展表信息
	 */
	private TradeExt tradeExt;

	/**
	 * 交易备注。
	 */
	private String tradeMemo;

	/**
	 * 交易外部来源
	 */
	private String tradeSource;

	/**
	 * 交易类型列表，同时查询多种交易类型可用逗号分隔。默认同时查询guarantee_trade, auto_delivery, ec,
	 * cod的4种交易类型的数据 可选值 fixed(一口价) auction(拍卖) guarantee_trade(一口价、拍卖)
	 * auto_delivery(自动发货) independent_simple_trade(旺店入门版交易)
	 * independent_shop_trade(旺店标准版交易) ec(直冲) cod(货到付款) fenxiao(分销)
	 * game_equipment(游戏装备) shopex_trade(ShopEX交易) netcn_trade(万网交易)
	 * external_trade(统一外部交易) o2o_offlinetrade（O2O交易） step (万人团) nopaid(无付款订单)
	 * pre_auth_type(预授权0元购机交易)
	 */
	private String type;

	/**
	 * 订单的运费险，单位为元
	 */
	private String yfxFee;

	/**
	 * 运费险支付号
	 */
	private String yfxId;

	/**
	 * 运费险类型
	 */
	private String yfxType;

	/**
	 * 在返回的trade对象上专门增加一个字段zero_purchase来区分，这个为true的就是0元购机预授权交易
	 */
	private Boolean zeroPurchase;
}
