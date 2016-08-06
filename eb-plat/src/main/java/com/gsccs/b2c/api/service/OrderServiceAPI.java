package com.gsccs.b2c.api.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.order.model.OrderPayT;
import com.gsccs.b2c.plat.order.model.OrderStatist;
import com.gsccs.b2c.plat.order.model.OrderTrace;
import com.gsccs.b2c.plat.order.service.OrderService;
import com.gsccs.b2c.plat.order.service.PaymentService;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.Order.OrderState;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 订单服务接口
 * @author x.d zhang
 *
 */
public class OrderServiceAPI implements OrderServiceI {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ShopService storeService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private PaymentService paymentService;

	@Override
	public Order getOrder(Long sid, Long oId) throws ApiException {
		if (null == sid || null == oId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		return orderService.findById(oId);
	}

	@Override
	public String createOrder(Long sid, Order order, List<OrderItem> items)
			throws ApiException {
		String oid = null;
		if (null == sid || null == order) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		try {
			order.setStatus(OrderState.WAIT_PAY.name());
			oid = orderService.insert(sid, order, items);

			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.CREATE.name());
			trace.setOrderid(oid);
			trace.setSiteid(sid);
			trace.setOperuser("客户");
			trace.setRemark("您提交了订单，请等待系统确认.");
			orderService.addTrace(sid, trace);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oid;
	}
	
	@Override
	public List<Order> getSellerOrderList(Long sid, Order order, String orderstr,
			int currPage, int pageSize) throws ApiException {
		List<Order> list = orderService.queryOrderBySeller(order, orderstr, currPage,
				pageSize);
		
		return list;
	}
	
	@Override
	public List<Order> getBuyerOrderList(Long sid, Order param, String order,
			int currPage, int pageSize) throws ApiException {
		List<Order> ordertList = orderService.queryOrderByBuyer(param, order, currPage,
				pageSize);
		return ordertList;
	}

	@Override
	public int getOrderCount(Long sid, Order param) throws ApiException {
		int count = orderService.count(sid, param);
		return count;
	}

	
	@Override
	public Long editOrderRefundStatus(Long sid, Long oid, String refundStatus)
			throws ApiException {
		Order order = orderService.findById(oid);
		orderService.update(order, sid);
		return oid;
	}

	
	
	@Override
	public Long editOrderShipFee(Long sid, Long oid, Double shipfee)
			throws ApiException {
		Order order = orderService.findById(oid);
		order.setShipfee(Double.valueOf(shipfee));
		orderService.update(order, sid);
		return oid;
	}

	@Override
	public List<OrderItem> getOrderItems(Long sid, Long oid)
			throws ApiException {
		List<OrderItem> list = orderService.findOItems(sid, oid);
		return list;
	}

	@Override
	public List<OrderItem> getIsNotEvalItems(Long sid, Long uid, int page,
			int pagesize) throws ApiException {
		List<OrderItem> list = orderService.findIsNotEvalItems(sid, uid, page,
				pagesize);
		return list;
	}

	@Override
	public JSONObject orderStatist(Long sid, Long uid) throws ApiException {
		JSONObject json = new JSONObject();
		if (null == sid || null == uid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		List<OrderStatist> staticResult = orderService.orderBuyerStatist(sid,
				uid);
		if (null != staticResult && staticResult.size() > 0) {
			for (OrderStatist orderStatist : staticResult) {
				try {
					json.put(orderStatist.getStatus(),
							orderStatist.getTotalnum());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		return json;
	}

	@Override
	public void orderCancel(Long sid, String ordersn) throws ApiException {
		if (null == sid || null == ordersn) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Order ordert = orderService.findByOrdersn(sid, ordersn);
		if (null != ordert) {
			ordert.setStatus(OrderState.CANCEL.name());
			orderService.update(ordert, sid);
			// 释放锁定的商品
			List<OrderItem> itemTs = orderService.findOItems(sid,
					ordert.getId());
			if (null != itemTs && itemTs.size() > 0) {
				for (OrderItem itemT : itemTs) {
					Goods product = goodsService.getGoods(
							itemT.getGoodsid());
					if (null != product && null != itemT.getNum()) {
						int locknum = product.getLocknum() - itemT.getNum();
						int storenum = product.getStorenum() + itemT.getNum();
						product.setLocknum(locknum < 0 ? 0 : locknum);
						product.setStorenum(storenum);
						goodsService.editGoods(sid, product);
					}
				}
			}
			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.CANCEL.name());
			trace.setOrderid(ordersn);
			trace.setSiteid(sid);
			orderService.addTrace(sid, trace);
		}
	}

	@Override
	public void orderPayment(Long sid, String ordersn) throws ApiException {
		if (null == sid || null == ordersn) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Order ordert = orderService.findByOrdersn(sid, ordersn);
		// 待支付订单执行此操作
		if (null != ordert
				&& ordert.getStatus().equals(OrderState.WAIT_PAY.name())) {
			ordert.setStatus(OrderState.PAYED.name());
			orderService.update(ordert, sid);

			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.PAYED.name());
			trace.setOrderid(ordersn);
			trace.setSiteid(sid);
			orderService.addTrace(sid, trace);
		}
	}

	
	@Override
	public void orderAlipayPayment(Long sid, String ordersn, String tardeno,
			String total_fee) throws ApiException {
		if (null == sid || null == ordersn) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Order ordert = orderService.findByOrdersn(sid, ordersn);
		// 待支付订单执行此操作
		if (null != ordert
				&& ordert.getStatus().equals(OrderState.WAIT_PAY.name())) {
			ordert.setStatus(OrderState.PAYED.name());
			orderService.update(ordert, sid);

			double payfee = 0.00;
			if (StringUtils.isNotEmpty(total_fee)){
				payfee = Double.valueOf(total_fee);
			}
			
			//支付记录
			OrderPayT orderPayT = new OrderPayT();
			orderPayT.setOrdersn(ordersn);
			orderPayT.setTradeno(tardeno);
			orderPayT.setStoreid(sid);
			orderPayT.setPayfee(payfee);
			paymentService.addOrderPay(orderPayT);
			
			//订单跟踪
			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.PAYED.name());
			trace.setOrderid(ordersn);
			trace.setSiteid(sid);
			orderService.addTrace(sid, trace);
		}
	}
	
	@Override
	public void orderShipMents(Long sid, String ordersn, String code,
			String logistnum) {
		Order order = orderService.findByOrdersn(sid, ordersn);
		if (null != order) {
			order.setLogistnum(logistnum);
			order.setDelivercode(code);
			order.setStatus(OrderState.SENDED.name());
			orderService.update(order, sid);

			// 更新商品销量(扣减锁定数量)
			List<OrderItem> itemTs = orderService.findOItems(sid,
					order.getId());
			if (null != itemTs && itemTs.size() > 0) {
				for (OrderItem itemT : itemTs) {
					Goods product = goodsService.getGoods(
							itemT.getGoodsid());
					if (null != product && null != itemT.getNum()) {
						int salenum = product.getSalenum() + itemT.getNum();
						int locknum = product.getLocknum() - itemT.getNum();
						product.setSalenum(salenum);
						product.setLocknum(locknum < 0 ? 0 : locknum);
						goodsService.editGoods(sid, product);
					}
				}
			}

			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.SENDED.name());
			trace.setOrderid(ordersn);
			trace.setSiteid(sid);
			trace.setRemark("您的货物已寄出,物流单号：" + logistnum + ",物流公司:" + code);
			orderService.addTrace(sid, trace);
		}
	}

	
	@Override
	public void orderReceived(Long sid, String ordersn) throws ApiException {
		if (null == sid || null == ordersn) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Order ordert = orderService.findByOrdersn(sid, ordersn);
		if (null != ordert) {
			ordert.setStatus(OrderState.RECEIVED.name());
			orderService.update(ordert, sid);

			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.RECEIVED.name());
			trace.setOrderid(ordersn);
			trace.setSiteid(sid);
			orderService.addTrace(sid, trace);
		}

	}

	@Override
	public void orderEvaled(Long sid, String ordersn) throws ApiException {
		if (null == sid || null == ordersn) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Order ordert = orderService.findByOrdersn(sid, ordersn);
		// 评价状态商品
		if (null != ordert
				&& ordert.getStatus().equals(OrderState.RECEIVED.name())) {
			ordert.setStatus(OrderState.EVALED.name());
			orderService.update(ordert, sid);

			// 更新商品评价次数
			List<OrderItem> itemTs = orderService.findOItems(sid,
					ordert.getId());
			if (null != itemTs && itemTs.size() > 0) {
				for (OrderItem itemT : itemTs) {
					Goods product = goodsService.getGoods(
							itemT.getGoodsid());
					if (null != product && null != itemT.getNum()) {
						int evalnum = product.getEvalnum() == null ? 0
								: product.getEvalnum();
						product.setEvalnum(evalnum + 1);
						goodsService.editGoods(sid, product);
					}
				}
			}

			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.EVALED.name());
			trace.setOrderid(ordersn);
			trace.setSiteid(sid);
			orderService.addTrace(sid, trace);
		}
	}

	@Override
	public JSONArray orderTraceList(Long sid, String orderid)
			throws ApiException {
		List<OrderTrace> orderTraces = orderService.findOrderTraces(sid,
				orderid);
		if (null != orderTraces) {
			return (JSONArray) JSON.toJSON(orderTraces);
		}
		return null;
	}

	@Override
	public boolean orderdelete(Long sid, String orderid) {
		try {
			orderService.deleteOrder(sid, orderid);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	
}
