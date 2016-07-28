package com.gsccs.b2c.store.order.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.service.GoodsServiceI;
import com.gsccs.b2c.api.service.DeliverServiceI;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.store.base.JsonMsg;
import com.gsccs.eb.api.domain.deliver.DeliverType;
import com.gsccs.eb.api.domain.deliver.DlyCorp;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.trade.Order;
import com.gsccs.eb.api.domain.trade.OrderItem;
import com.gsccs.eb.api.domain.trade.Order.OrderState;
import com.gsccs.eb.api.exception.ApiException;
import com.gsccs.eb.api.utils.Datagrid;

/**
 * 商家订单管理
 * @author think
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServiceI orderAPI;
	
	@Autowired
	private DeliverServiceI logistServiceAPI;
	
	@Autowired
	private GoodsServiceI goodsServiceAPI;
	
	/**
	 * 跳转到订单页面
	 * @return
	 */
	@RequestMapping(value="/orderList")
	public String orderList(){
		return "order/order_list";
	}
	
	
	/**
	 * 获得订单数据
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param o
	 * @param request
	 * @return
	 * @throws ApiException 
	 */
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " serialnum  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			Order o, HttpServletRequest request) throws ApiException {
		
		long sid = (Long) request.getSession().getAttribute("siteId");
		o.setState(OrderState.valueOf(o.getState().name()));
		int count = orderAPI.getOrderCount(sid, o);
		List<Order> orderList = orderAPI.getOrderList(sid, o, order, page, rows);
		if(null !=orderList && orderList.size() > 0){
			for (Order o2 : orderList) {
				if(o2.getState().name().equals("WAIT_PAY")){
					o2.setStateStr("待支付");
				}else if(o2.getState().name().equals("PAYED")){
					o2.setStateStr("已支付");
				}else if(o2.getState().name().equals("WAIT_SEND")){
					o2.setStateStr("待发货");
				}else if(o2.getState().name().equals("SENDED")){
					o2.setStateStr("已发货");
				}else if(o2.getState().name().equals("WAIT_RECEIVE")){
					o2.setStateStr("待确认收货");
				}else if(o2.getState().name().equals("SUCCESSED")){
					o2.setStateStr("交易完成");
				}else if(o2.getState().name().equals("CANCEL")){
					o2.setStateStr("已取消");
				}else if(o2.getState().name().equals("CLOSED")){
					o2.setStateStr("已关闭");
				}
			}
		}
		
		Datagrid datagrid = new Datagrid();
		if(null !=orderList){
			datagrid.setRows(orderList);
		}
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 跳转到订单运费页面
	 * @return
	 */
	@RequestMapping(value="/orderEdit")
	public String orderEdit(String id,Model model,HttpServletRequest request){
		long sid = (Long) request.getSession().getAttribute("siteId");
		Order order;
		List<OrderItem> oiList = null;
		Product product;
		try {
			order = orderAPI.getOrder(sid, Long.valueOf(id));
			oiList =orderAPI.getOrderItems(sid, order.getId());
			System.out.println("oilist="+oiList.size());
			//获得产品Id
			if(null !=oiList && oiList.size() >0){
				long pid  =oiList.get(0).getProductid();
				if(pid > 0 ){
					product = goodsServiceAPI.getProduct(sid, pid);
					model.addAttribute("product", product);
				}
				model.addAttribute("oItemsList", oiList);
			}
			
			model.addAttribute("order", order);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "order/order_edit";
	}
	
	/**
	 * 修改订单运费
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/orderEditDo")
	@ResponseBody
	public JsonMsg orderEidtDo(Order order,HttpServletRequest request){
		JsonMsg jsonMsg = new JsonMsg();
		long sid = (Long) request.getSession().getAttribute("siteId");
		if(null != order){
			try {
				orderAPI.editOrderShipFee(sid, order.getId(), order.getShipfee());
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("订单修改成功！");
			} catch (ApiException e) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("订单修改失败！");
			}
			
		}else{
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("订单修改失败！");
		}
		return jsonMsg;
		
	}
	
	/**
	 * 取消订单
	 * @param order
	 * @return  status=6;交易关闭
	 */
	@RequestMapping(value="/orderCancelDo")
	@ResponseBody
	public JsonMsg orderCancelDo(String id,HttpServletRequest request){
		JsonMsg jsonMsg = new JsonMsg();
		long sid = (Long) request.getSession().getAttribute("siteId");
		if(!id.equals("")){
			try {
				orderAPI.orderCancel(sid, id);
				jsonMsg.setSuccess(true);
				jsonMsg.setMsg("取消订单成功！");
			} catch (ApiException e) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("取消订单失败！");
			}
			
		}else{
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("取消订单失败！");
		}
		return jsonMsg;
		
	}
	
	
	/**
	 * 跳转到订单发货页面
	 * @return 		
	 */
	@RequestMapping(value="/orderShipments")
	public String orderShipments(String id,Model model,HttpServletRequest request){
		long sid = (Long) request.getSession().getAttribute("siteId");
		List<OrderItem> oiList = null;
		Order order;
		Product product;
		DeliverType dt;
		DlyCorp dc;
		try {
			order = orderAPI.getOrder(sid, Long.valueOf(id));
			oiList =orderAPI.getOrderItems(sid, order.getId());
			//获得产品Id
			if(null !=oiList && oiList.size() >0){
				long pid  =oiList.get(0).getProductid();
				if(pid > 0 ){
					product = goodsServiceAPI.getProduct(sid, pid);
					if(null != product && product.getPostage().trim().length() >0){
						dt =logistServiceAPI.findDeliverType(product.getPostage());
						if(null !=dt && dt.getCorpid().trim().length() >0){
							
							dc =logistServiceAPI.findDlyCorp(Integer.valueOf(dt.getCorpid()));
							if(null !=dc){
								model.addAttribute("deliver", dc);
							}
								
						}
						model.addAttribute("product", product);
					}
					
				}
			}
			model.addAttribute("order", order);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "order/order_shipments";
	}
	
	/**
	 * 显示订单详情
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/orderShow")
	public String orderShow(String id,Model model,HttpServletRequest request){
		long sid = (Long) request.getSession().getAttribute("siteId");
		List<OrderItem> oiList = null;
		Order order;
		Product product;
		DeliverType dt;
		DlyCorp dc;
		try {
			order = orderAPI.getOrder(sid, Long.valueOf(id));
			oiList =orderAPI.getOrderItems(sid, order.getId());
			//获得产品Id
			if(null !=oiList && oiList.size() >0){
				long pid  =oiList.get(0).getProductid();
				if(pid > 0 ){
					product = goodsServiceAPI.getProduct(sid, pid);
					if(null != product && product.getPostage().trim().length() >0){
						dt =logistServiceAPI.findDeliverType(product.getPostage());
						if(null !=dt && dt.getCorpid().trim().length() >0){
							
							dc =logistServiceAPI.findDlyCorp(Integer.valueOf(dt.getCorpid()));
							if(null !=dc){
								model.addAttribute("deliver", dc);
							}
								
						}
						model.addAttribute("product", product);
					}
					
				}
			}
			model.addAttribute("order", order);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "order/order_detail";
	}

	/**
	 * 发货保存
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/orderShipmentsDo")
	@ResponseBody
	public JsonMsg OrderShipmentsDo(String id,String logistnum, String code,HttpServletRequest request){
		JsonMsg jsonMsg = new JsonMsg();
		long sid = (Long) request.getSession().getAttribute("siteId");
		if(null != id && null !=logistnum && null !=code){
			orderAPI.orderShipMents(sid, id, code, logistnum);
			jsonMsg.setSuccess(true);
			jsonMsg.setMsg("发货成功！");
		}else{
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("发货失败！");
		}
		return jsonMsg;
		
	}
}
