package com.gsccs.b2c.plat.warehouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.order.model.OrderT;
import com.gsccs.b2c.plat.order.service.OrderService;

/**
 * 平台订单管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	private OrderService orderService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String list(){
		return "order/list";
	}
	
	
	@RequestMapping(value = "/datagrid",method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(@RequestParam(defaultValue = " addtime desc ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			OrderT orderT, HttpServletRequest request) {
		List<OrderT> orderlist = orderService.find(orderT, 1001L,order, currPage,
				pageSize);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(orderlist);
		return datagrid;
	}
	
}
