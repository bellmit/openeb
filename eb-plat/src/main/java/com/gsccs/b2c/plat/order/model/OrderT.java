package com.gsccs.b2c.plat.order.model;

import com.gsccs.b2c.api.domain.Order;

/**
 * 订单实体类
 * @author x.d zhang
 *
 */
public class OrderT extends Order{

	private String status;
	//锁定商品数量
	private Integer locknum;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}
	
	
	
}