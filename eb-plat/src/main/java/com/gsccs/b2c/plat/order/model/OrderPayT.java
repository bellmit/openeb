package com.gsccs.b2c.plat.order.model;


public class OrderPayT {

	private Long id;
	private String ordersn;
	private Long storeid;
	private Double payfee;
	private String tradeno;
	private String tradestatus;
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrdersn() {
		return ordersn;
	}

	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn == null ? null : ordersn.trim();
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

	
	public Double getPayfee() {
		return payfee;
	}

	public void setPayfee(Double payfee) {
		this.payfee = payfee;
	}

	public String getTradeno() {
		return tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno == null ? null : tradeno.trim();
	}

	public String getTradestatus() {
		return tradestatus;
	}

	public void setTradestatus(String tradestatus) {
		this.tradestatus = tradestatus == null ? null : tradestatus.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
}