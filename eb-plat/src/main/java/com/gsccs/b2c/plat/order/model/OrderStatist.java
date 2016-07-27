package com.gsccs.b2c.plat.order.model;

/**
 * 订单状态统计结果
 * 
 * @author x.d zhang
 * 
 */
public class OrderStatist {

	public String status;
	public int totalnum;
	public Double totalfee;
	private Long storeid;
	private String statday;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public Double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(Double totalfee) {
		this.totalfee = totalfee;
	}

	public Long getStoreid() {
		return storeid;
	}

	public void setStoreid(Long storeid) {
		this.storeid = storeid;
	}

	public String getStatday() {
		return statday;
	}

	public void setStatday(String statday) {
		this.statday = statday;
	}
	
	

}
