package com.gsccs.eb.api.domain.trade;

import java.util.Date;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 支付记录
 * @author x.d zhang
 *
 */
public class PayNote extends Domain {

	private Long id;
	private String payno;
	private Long buyerid;
	private Long shopid;
	private String typeid;
	private Long orderid;
	private String ordersn;
	private String payaccount;
	private String recaccount;
	private Integer payfee;
	private Date paytime;
	private String transid;
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayno() {
		return payno;
	}

	public void setPayno(String payno) {
		this.payno = payno;
	}

	public Long getBuyerid() {
		return buyerid;
	}

	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getOrdersn() {
		return ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}

	public String getPayaccount() {
		return payaccount;
	}

	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}

	public String getRecaccount() {
		return recaccount;
	}

	public void setRecaccount(String recaccount) {
		this.recaccount = recaccount;
	}

	public Integer getPayfee() {
		return payfee;
	}

	public void setPayfee(Integer payfee) {
		this.payfee = payfee;
	}

	public Date getPaytime() {
		return paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}