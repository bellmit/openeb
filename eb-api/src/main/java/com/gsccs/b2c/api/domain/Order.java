package com.gsccs.b2c.api.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单结构
 * 
 * @author x.d zhang
 * 
 */
public class Order extends DomainObject {

	private static final long serialVersionUID = 3167666115781348253L;

	private Long id;
	// 订单序列号
	private String serialnum;
	// 买家ID
	private Long buyerid;
	// 买家昵称
	private String buyernick;
	// 商城ID
	private Long storeid;
	// 商城名称
	private String storename;
	private String paytype;

	// 物流类型
	private String shiptype;
	// 物流费用
	private Double shipfee;
	// 联系电话
	private String telnum;
	private String phone;
	// 收货人
	private String consignee;
	// 收货地址
	private String receaddress;
	// 订单类型
	private String ordertype;
	private String isdelay;
	// 订单总额
	private Double totalfee;
	// 商品总数
	private Integer totalnum;

	private String isdistrib;
	private Double distribfee;
	private String isbilling;
	// 积分
	private Integer gainscore;
	private Long couponid;
	private Double couponfee;
	private Long activityid;
	private Double activityfee;

	private String platsource;
	// 下单时间
	private Date addtime;
	private Date lasttime;
	private String operation;
	// 物流单号
	private String logistnum;
	// 快递公司code
	private String delivercode;

	// 商品名称
	private String productName;
	/**/// 状态显示
	private String stateStr;
	// 下单时间
	private String adddatestr;
	
	private String lastdatestr;
	// 订单状态
	private OrderState state;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum == null ? null : serialnum.trim();
	}


	public Long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}

	public String getBuyernick() {
		return buyernick;
	}

	public void setBuyernick(String buyernick) {
		this.buyernick = buyernick == null ? null : buyernick.trim();
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename == null ? null : storename.trim();
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype == null ? null : paytype.trim();
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum == null ? null : telnum.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getShiptype() {
		return shiptype;
	}

	public void setShiptype(String shiptype) {
		this.shiptype = shiptype == null ? null : shiptype.trim();
	}

	public Double getShipfee() {
		return shipfee;
	}

	public void setShipfee(Double shipfee) {
		this.shipfee = shipfee;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee == null ? null : consignee.trim();
	}

	public String getReceaddress() {
		return receaddress;
	}

	public void setReceaddress(String receaddress) {
		this.receaddress = receaddress == null ? null : receaddress.trim();
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype == null ? null : ordertype.trim();
	}

	public String getIsdelay() {
		return isdelay;
	}

	public void setIsdelay(String isdelay) {
		this.isdelay = isdelay == null ? null : isdelay.trim();
	}

	public Double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	public String getIsdistrib() {
		return isdistrib;
	}

	public void setIsdistrib(String isdistrib) {
		this.isdistrib = isdistrib == null ? null : isdistrib.trim();
	}

	public Double getDistribfee() {
		return distribfee;
	}

	public void setDistribfee(Double distribfee) {
		this.distribfee = distribfee;
	}

	public String getIsbilling() {
		return isbilling;
	}

	public void setIsbilling(String isbilling) {
		this.isbilling = isbilling == null ? null : isbilling.trim();
	}

	public Integer getGainscore() {
		return gainscore;
	}

	public void setGainscore(Integer gainscore) {
		this.gainscore = gainscore;
	}

	public Long getCouponid() {
		return couponid;
	}

	public void setCouponid(Long couponid) {
		this.couponid = couponid;
	}

	public Double getCouponfee() {
		return couponfee;
	}

	public void setCouponfee(Double couponfee) {
		this.couponfee = couponfee;
	}

	public Long getActivityid() {
		return activityid;
	}

	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}

	public Double getActivityfee() {
		return activityfee;
	}

	public void setActivityfee(Double activityfee) {
		this.activityfee = activityfee;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public String getLogistnum() {
		return logistnum;
	}

	public void setLogistnum(String logistnum) {
		this.logistnum = logistnum == null ? null : logistnum.trim();
	}

	public String getPlatsource() {
		return platsource;
	}

	public void setPlatsource(String platsource) {
		this.platsource = platsource == null ? null : platsource.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getAdddatestr() {
		if (null != getAddtime()) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			adddatestr = df.format(getAddtime());
		}
		return adddatestr;
	}

	public void setAdddatestr(String adddatestr) {
		this.adddatestr = adddatestr;
	}

	
	public String getDelivercode() {
		return delivercode;
	}

	public void setDelivercode(String delivercode) {
		this.delivercode = delivercode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}


	public static enum OrderState {
		CREATE("创建"), 
		WAIT_PAY("待支付"), 
		PAYED("已支付"), 
		WAIT_SEND("待发货"),
		SENDED("已发货"), 
		WAIT_RECEIVE("待确认收货"), 
		RECEIVED("已收货"),
		EVALED("已评价"), 
		SUCCESSED("交易完成"), 
		CANCEL("已取消"), 
		CLOSED("已关闭");

		private final String type;

		private OrderState(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}

	public String getLastdatestr() {
		if (null != getLasttime()) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			lastdatestr = df.format(getLasttime());
		}
		return lastdatestr;
	}

	public void setLastdatestr(String lastdatestr) {
		this.lastdatestr = lastdatestr;
	}
	
	

}
