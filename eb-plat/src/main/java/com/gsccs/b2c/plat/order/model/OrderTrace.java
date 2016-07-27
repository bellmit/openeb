package com.gsccs.b2c.plat.order.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单跟踪记录
 * 
 * @author x.d zhang
 * 
 */
public class OrderTrace {

	private String id;
	private String orderid;
	private String operuser;
	private String operate;
	private Date opttime;
	private String remark;
	private Long siteid;

	private String opttimestr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid == null ? null : orderid.trim();
	}

	public String getOperuser() {
		return operuser;
	}

	public void setOperuser(String operuser) {
		this.operuser = operuser == null ? null : operuser.trim();
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate == null ? null : operate.trim();
	}

	public Date getOpttime() {
		return opttime;
	}

	public void setOpttime(Date opttime) {
		this.opttime = opttime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	public String getOpttimestr() {
		if (null != getOpttime()) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			opttimestr = df.format(getOpttime());
		}
		return opttimestr;
	}

	public void setOpttimestr(String opttimestr) {
		this.opttimestr = opttimestr;
	}

}