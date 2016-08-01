package com.gsccs.b2c.plat.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsccs.b2c.plat.order.service.OrderService;
import com.gsccs.eb.api.domain.trade.Order;

/**
 * 平台订单管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 卖家订单列表
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String orderList(
			@RequestParam(defaultValue = " addtime desc ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Order param) {
		List<Order> orderlist = orderService.queryOrderBySeller(param,order, currPage,
				pageSize);
		map.put("orderList", orderlist);
		return "trade/order_list";
	}
	
	/**
	 * 订单详情
	 * @param id
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public String orderDetail(Long id,ModelMap map,HttpServletRequest request) {
		Order order = orderService.findById(id);
		map.put("order", order);
		return "trade/order_detail";
	}
	
	
	@RequestMapping(value="/refund",method = RequestMethod.GET)
	public String refundList(
			@RequestParam(defaultValue = " addtime desc ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Order param, HttpServletRequest request) {
		List<Order> orderlist = orderService.queryOrderBySeller(param,order, currPage,
				pageSize);
		map.put("orderList", orderlist);
		return "trade/refund_list";
	}
	
	
}
