package com.gsccs.eb.api.domain.trade;

/**
 * 订单状态对象
 * 
 * @author x.d zhang
 * 
 */
public abstract class OrderState {

	public abstract void cancel();

	public abstract void grant();

	public abstract void ship();

	public abstract void invoice();

}
