package com.gsccs.b2c.api.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 订单API
 * 
 * @创建人：x.j niu
 * @类名称：OrderServiceI
 * @创建时间：2015年4月22日 下午2:36:16
 */
public interface OrderServiceI {

	/**
	 * 根据店铺Id和订单Id查询
	 * 
	 * @param sid
	 * @param oId
	 * @return
	 */
	public Order getOrder(Long sid, Long oId) throws ApiException;

	/**
	 * 获得订单商品子项
	 * 
	 * @return
	 * @throws ApiException
	 */
	public List<OrderItem> getOrderItems(Long sid, Long oId)
			throws ApiException;

	/**
	 * 获得未评价商品
	 * 
	 * @param sid
	 *            站点数字ID
	 * @param uid
	 *            用户数字ID
	 * @return
	 * @throws ApiException
	 */
	public List<OrderItem> getIsNotEvalItems(Long sid, Long uid, int page,
			int pagesize) throws ApiException;

	/**
	 * 添加订单
	 * 
	 * @param sid
	 * @param order
	 * @return
	 */
	public String createOrder(Long sid, Order order, List<OrderItem> items)
			throws ApiException;

	/**
	 * 订单取消
	 * 
	 * @param sid
	 * @param order
	 * @return
	 */
	public void orderCancel(Long sid, String ordersn) throws ApiException;

	/**
	 * 订单支付
	 * 
	 * @param sid
	 * @param ordersn
	 * @return
	 */
	public void orderPayment(Long sid, String ordersn) throws ApiException;

	/**
	 * 支付宝支付
	 * @param sid
	 * @param ordersn
	 * @throws ApiException
	 */
	public void orderAlipayPayment(Long sid, String ordersn,String tardeno,String total_fee) throws ApiException;
	
	
	/**
	 * 
	 * 订单收货确认
	 * 
	 * @param sid
	 * @param ordersn
	 * @return
	 */
	public void orderReceived(Long sid, String ordersn) throws ApiException;

	/**
	 * 订单评价
	 * 
	 * @param sid
	 * @param ordersn
	 * @return
	 */
	public void orderEvaled(Long sid, String ordersn) throws ApiException;

	/**
	 * 修改订单状态
	 * 
	 * @param sid
	 * @param oid
	 * @param OrderState
	 * @return
	 * @throws ApiException
	 */
	/*
	 * public Long editOrder(Long sid, Long oid, String OrderState) throws
	 * ApiException;
	 */

	/**
	 * 修改订单，修改物流费用
	 * 
	 * @param sid
	 * @param oid
	 * @param shipFee
	 * @return
	 * @throws ApiException
	 */
	public Long editOrderShipFee(Long sid, Long oid, Double shipFee)
			throws ApiException;

	/**
	 * 修改订单，发货
	 * 
	 * @param sid
	 * @param ordersn
	 * @param shipMethod
	 * @param logisticsNum
	 * @return
	 */
	public void orderShipMents(Long sid, String ordersn, String shipMethod,
			String logisticsNum);

	/**
	 * 获得卖家订单
	 * 
	 * @param sid
	 * @param o
	 * @return
	 * @throws ApiException
	 */
	public List<Order> getOrderList(Long sid, Order o, String order,
			int currPage, int pageSize) throws ApiException;

	/**
	 * 获得买家订单信息
	 * 
	 * @param sid
	 * @param o
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @return
	 * @throws ApiException
	 */
	public List<Order> getBuyerOrderList(Long sid, Order o, String order,
			int currPage, int pageSize) throws ApiException;

	/**
	 * 修改订单
	 * 
	 * @param sid
	 * @param o
	 * @return
	 * @throws ApiException
	 */
	// public Long editOrder(Long sid, Order o) throws ApiException;

	/**
	 * 根据条件查询符合条件的条数
	 * 
	 * @param sid
	 * @param o
	 * @return
	 * @throws ApiException
	 */
	public int getOrderCount(Long sid, Order o) throws ApiException;

	/**
	 * 修改退单状态
	 * 
	 * @param sid
	 * @param oid
	 * @param refundStatus
	 * @return
	 * @throws ApiException
	 */
	public Long editOrderRefundStatus(Long sid, Long oid, String refundStatus)
			throws ApiException;

	/**
	 * 会员订单统计
	 * 
	 * @param sid
	 * @param uid
	 * @return
	 */
	public JSONObject orderStatist(Long sid, Long uid) throws ApiException;

	/**
	 * 订单跟踪列表
	 * 
	 * @param sid
	 * @param uid
	 * @return
	 */
	public JSONArray orderTraceList(Long sid, String orderid)
			throws ApiException;

	/**
	 * 订单删除
	 * 
	 * @param orderid
	 * @return
	 */
	public boolean orderdelete(Long sid, String orderid) throws ApiException;
}
