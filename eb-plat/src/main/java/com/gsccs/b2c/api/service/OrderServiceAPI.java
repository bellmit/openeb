package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.Order;
import com.gsccs.b2c.api.domain.Order.OrderState;
import com.gsccs.b2c.api.domain.OrderItem;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.order.model.OrderItemT;
import com.gsccs.b2c.plat.order.model.OrderPayT;
import com.gsccs.b2c.plat.order.model.OrderStatist;
import com.gsccs.b2c.plat.order.model.OrderT;
import com.gsccs.b2c.plat.order.model.OrderTrace;
import com.gsccs.b2c.plat.order.service.OrderService;
import com.gsccs.b2c.plat.order.service.PaymentService;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.ProductT;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.utils.BeanUtilsEx;

/**
 * 订单服务接口
 * @author x.d zhang
 *
 */
public class OrderServiceAPI implements OrderServiceI {

	@Autowired
	private OrderService orderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private PaymentService paymentService;

	@Override
	public Order getOrder(Long sid, Long oId) throws ApiException {
		Order o = null;
		if (null == sid || null == oId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		OrderT t = orderService.findById(sid, oId);
		if (null != t) {
			o = new Order();
			try {
				BeanUtils.copyProperties(o, t);
				o.setState(OrderState.valueOf(t.getStatus()));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return o;
	}

	@Override
	public String createOrder(Long sid, Order o, List<OrderItem> items)
			throws ApiException {
		String oid = null;
		if (null == sid || null == o) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		List<OrderItemT> itemts = new ArrayList<OrderItemT>();
		OrderT ordert = new OrderT();
		try {
			BeanUtilsEx.copyProperties(ordert, o);
			if (null == items || items.size() <= 0) {
				throw new ApiException(APIConst.ERROR_CODE_0001,
						APIConst.ERROR_MSG_0001);
			} else {
				for (int i = 0; i < items.size(); i++) {
					OrderItemT itemt = new OrderItemT();
					BeanUtils.copyProperties(itemt, items.get(i));
					itemts.add(itemt);
				}
			}
			ordert.setStatus(OrderState.WAIT_PAY.name());
			oid = orderService.insert(sid, ordert, itemts);

			OrderTrace trace = new OrderTrace();
			trace.setOperate(OrderState.CREATE.name());
			trace.setOrderid(oid);
			trace.setSiteid(sid);
			trace.setOperuser("客户");
			trace.setRemark("您提交了订单，请等待系统确认.");
			orderService.addTrace(sid, trace);
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return oid;
	}
	
	@Override
	public List<Order> getOrderList(Long sid, Order o, String order,
			int currPage, int pageSize) throws ApiException {
		List<Order> list = null;
		OrderT t = new OrderT();
		if (null != o) {
			BeanUtilsEx.copyProperties(t, o);
			t.setStatus(null == o.getState() ? "" : o.getState().name());
		}

		List<OrderT> orderts = orderService.find(t, sid, order, currPage,
				pageSize);

		if (null != orderts && orderts.size() > 0) {
			list = new ArrayList<Order>();
			for (OrderT ordert : orderts) {
				Order order_ = new Order();
				BeanUtilsEx.copyProperties(order_, ordert);
				order_.setState(OrderState.valueOf(ordert.getStatus()));
				list.add(order_);
			}
		}
		return list;
	}
	
/*
	@Override
	public List<Order> getOrderList(Long sid, Order o, String order,
			int currPage, int pageSize) throws ApiException {
		List<Order> list = null;
		OrderT t = new OrderT();
		if (null != o) {
			BeanUtilsEx.copyProperties(t, o);
			t.setStatus(null == o.getState() ? "" : o.getState().name());
		}

		List<OrderT> orderts = orderService.find(t, sid, order, currPage,
				pageSize);

		if (null != orderts && orderts.size() > 0) {
			list = new ArrayList<Order>();
			for (OrderT ordert : orderts) {
				Order order_ = new Order();
				BeanUtilsEx.copyProperties(order_, ordert);
				order_.setState(OrderState.valueOf(ordert.getStatus()));
				// 页面操作
				String operation = "";
				// 2,待付款
				if (ordert.getStatus().equals("WAIT_PAY")) {
					operation = "<a href=\"#\" onclick=\"javascript:show_order('"
							+ ordert.getId()
							+ "')\">查看订单</a>"
							+ "&nbsp;/&nbsp;"
							+ "<a href=\"#\" onclick=\"javascript:cancel_order('"
							+ ordert.getId()
							+ "')\">取消订单</a>"
							+ "&nbsp;/&nbsp;"
							+ "<a href=\"#\" onclick=\"javascript:update_order('"
							+ ordert.getId() + "')\">修改订单</a>";
				}
				// 3,待发货
				else if (ordert.getStatus().equals("WAIT_SEND")) {
					operation = "<a href=\"#\" onclick=\"javascript:show_order('"
							+ ordert.getId()
							+ "')\">查看订单</a>"
							+ "&nbsp;/&nbsp;"
							+ "<a href=\"#\" onclick=\"javascript:shipments_order('"
							+ ordert.getId() + "')\">发货</a>";
				}// 4,待确认
				else if (ordert.getStatus().equals("WAIT_RECEIVE")) {
					operation = "<a href=\"#\" onclick=\"javascript:show_order('"
							+ ordert.getId() + "')\">查看订单</a>";
				} else {
					operation = "<a href=\"#\" onclick=\"javascript:show_order('"
							+ ordert.getId() + "')\">查看订单</a>";
				}
				order_.setOperation(operation);
				list.add(order_);
			}
		}
		return list;
	}*/

	@Override
	public List<Order> getBuyerOrderList(Long sid, Order o, String order,
			int currPage, int pageSize) throws ApiException {
		OrderT t = null;
		if (null != o) {
			t = new OrderT();
			try {
				BeanUtils.copyProperties(t, o);
				t.setStatus(null == o.getState() ? null : o.getState().name());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		List<OrderT> ordertList = orderService.find(t, sid, order, currPage,
				pageSize);

		List<Order> apiOrderList = new ArrayList<Order>();
		for (OrderT ordert : ordertList) {
			Order apiOrder = new Order();
			try {
				BeanUtils.copyProperties(apiOrder, ordert);
				apiOrder.setState(OrderState.valueOf(ordert.getStatus()));
				apiOrderList.add(apiOrder);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return apiOrderList;
	}

	@Override
	public int getOrderCount(Long sid, Order param) throws ApiException {
		OrderT t = null;
		if (null != param) {
			t = new OrderT();
			BeanUtilsEx.copyProperties(t, param);
			t.setStatus(null == param.getState() ? null : param.getState()
					.name());
		}
		int count = orderService.count(sid, t);
		return count;
	}

	
	@Override
	public Long editOrderRefundStatus(Long sid, Long oid, String refundStatus)
			throws ApiException {
		OrderT order = orderService.findById(sid, oid);
		orderService.update(order, sid);
		return oid;
	}

	
	
	@Override
	public Long editOrderShipFee(Long sid, Long oid, Double shipfee)
			throws ApiException {
		OrderT order = orderService.findById(sid, oid);
		order.setShipfee(Double.valueOf(shipfee));
		orderService.update(order, sid);
		return oid;
	}

	@Override
	public List<OrderItem> getOrderItems(Long sid, Long oid)
			throws ApiException {
		List<OrderItem> list = new ArrayList<OrderItem>();
		List<OrderItemT> its = orderService.findOItems(sid, oid);
		if (null != its) {
			for (OrderItemT t : its) {
				OrderItem item = new OrderItem();
				try {
					BeanUtils.copyProperties(item, t);
					list.add(item);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public List<OrderItem> getIsNotEvalItems(Long sid, Long uid, int page,
			int pagesize) throws ApiException {
		List<OrderItemT> its = orderService.findIsNotEvalItems(sid, uid, page,
				pagesize);
		List<OrderItem> list = new ArrayList<OrderItem>();
		if (null != its) {
			for (OrderItemT t : its) {
				OrderItem item = new OrderItem();
				try {
					BeanUtils.copyProperties(item, t);
					list.add(item);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
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
		OrderT ordert = orderService.findByOrdersn(sid, ordersn);
		if (null != ordert) {
			ordert.setStatus(OrderState.CANCEL.name());
			orderService.update(ordert, sid);
			// 释放锁定的商品
			List<OrderItemT> itemTs = orderService.findOItems(sid,
					ordert.getId());
			if (null != itemTs && itemTs.size() > 0) {
				for (OrderItemT itemT : itemTs) {
					ProductT product = goodsService.getProduct(sid,
							itemT.getProductid(), false);
					if (null != product && null != itemT.getNum()) {
						int locknum = product.getLocknum() - itemT.getNum();
						int storenum = product.getStorenum() + itemT.getNum();
						product.setLocknum(locknum < 0 ? 0 : locknum);
						product.setStorenum(storenum);
						goodsService.editProduct(sid, product);
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
		OrderT ordert = orderService.findByOrdersn(sid, ordersn);
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
		OrderT ordert = orderService.findByOrdersn(sid, ordersn);
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
		OrderT order = orderService.findByOrdersn(sid, ordersn);
		if (null != order) {
			order.setLogistnum(logistnum);
			order.setDelivercode(code);
			order.setStatus(OrderState.SENDED.name());
			orderService.update(order, sid);

			// 更新商品销量(扣减锁定数量)
			List<OrderItemT> itemTs = orderService.findOItems(sid,
					order.getId());
			if (null != itemTs && itemTs.size() > 0) {
				for (OrderItemT itemT : itemTs) {
					ProductT product = goodsService.getProduct(sid,
							itemT.getProductid(), false);
					if (null != product && null != itemT.getNum()) {
						int salenum = product.getSalenum() + itemT.getNum();
						int locknum = product.getLocknum() - itemT.getNum();
						product.setSalenum(salenum);
						product.setLocknum(locknum < 0 ? 0 : locknum);
						goodsService.editProduct(sid, product);
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
		OrderT ordert = orderService.findByOrdersn(sid, ordersn);
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
		OrderT ordert = orderService.findByOrdersn(sid, ordersn);
		// 评价状态商品
		if (null != ordert
				&& ordert.getStatus().equals(OrderState.RECEIVED.name())) {
			ordert.setStatus(OrderState.EVALED.name());
			orderService.update(ordert, sid);

			// 更新商品评价次数
			List<OrderItemT> itemTs = orderService.findOItems(sid,
					ordert.getId());
			if (null != itemTs && itemTs.size() > 0) {
				for (OrderItemT itemT : itemTs) {
					ProductT product = goodsService.getProduct(sid,
							itemT.getProductid(), false);
					if (null != product && null != itemT.getNum()) {
						int evalnum = product.getEvalnum() == null ? 0
								: product.getEvalnum();
						product.setEvalnum(evalnum + 1);
						goodsService.editProduct(sid, product);
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
