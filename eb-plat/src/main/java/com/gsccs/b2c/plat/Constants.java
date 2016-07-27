package com.gsccs.b2c.plat;

import com.gsccs.b2c.api.domain.Order;
import com.gsccs.b2c.plat.order.model.OrderT;
import com.gsccs.b2c.plat.utils.BeanUtilsEx;

/**
 * <p>User: x.d zhang
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class Constants {
	
    public static final String CURRENT_USER = "user";

    public static final String SERVER_APP_KEY = "645ba616-370a-43a8-a8e0-993e7a590cf0";

    public static final String tempathPathCode = "TEMPLETE_PATH";
    
    /**
     * 订单状态
     * <li>ORDER_NO_CREATE_PAY(没有创建支付宝交易,1)
	 * <li>ORDER_WAIT_BUYER_PAY(等待买家付款,2)
	 * <li>ORDER_WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款,3)
	 * <li>ORDER_WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货,4)
	 * <li>ORDER_BUYER_SIGNED(买家已签收,货到付款专用,5)
	 * <li>ORDER_CLOSED(付款以后用户退款成功，交易自动关闭,6)
	 * <li>ORDER_PAY_PENDING(国际信用卡支付付款确认中,7)
	 * <li>ORDER_FINISHED(交易成功,0)
     */
    public static final String ORDER_NO_CREATE_PAY ="1";
    public static final String ORDER_WAIT_BUYER_PAY ="2";
    public static final String ORDER_WAIT_SELLER_SEND_GOODS ="3";
    public static final String ORDER_WAIT_BUYER_CONFIRM_GOODS ="4";
    public static final String ORDER_BUYER_SIGNED ="5";
    public static final String ORDER_CLOSED ="6";
    public static final String ORDER_PAY_PENDING ="7";
    public static final String ORDER_FINISHED ="0";
    
    
    
    public static void main(String[] args) {
    	Order order = new Order();
    	order.setTotalnum(100);
		OrderT ordert = new OrderT();
		try {
			BeanUtilsEx.copyProperties(ordert, order);
			System.out.println(ordert.getTotalnum());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    
}
