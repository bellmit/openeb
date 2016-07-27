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

import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.ReturnOrderServiceI;
import com.gsccs.b2c.store.base.JsonMsg;
import com.gsccs.eb.api.domain.trade.ReturnOrder;
import com.gsccs.eb.api.utils.Datagrid;

/**
 * 退单管理
 * @创建人：x.j  niu 
 * @类名称：ReturnOrderController
 * @创建时间：2015年6月11日 下午2:53:39
 */
@Controller
@RequestMapping("/returnOrder")
public class ReturnOrderController {
	
	@Autowired
	private ReturnOrderServiceI returnOrderAPI;
	
	/**
	 * 跳转到退单页面
	 * @return
	 */
	@RequestMapping(value="/rorderList")
	public String rOrderList(){
		return "order/r_order_list";
		
	}
	
	/**
	 * 获得退单信息
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param returnOrder
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			ReturnOrder returnOrder, HttpServletRequest request) throws ApiException {
		long sid = 1001;
		int count = returnOrderAPI.getrOrderCount(sid, returnOrder);
		List<ReturnOrder> orderList = returnOrderAPI.getrOrderList(sid, returnOrder, order, currPage, pageSize);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(orderList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	/**
	 * 跳转到退货审核页面
	 * @return
	 */
	@RequestMapping(value="/auditBackGoods")
	public String auditBackGoods(String id,Model model){
		long sid = 1001;
		ReturnOrder returnOrder ;
		try {
			returnOrder = returnOrderAPI.getReturnOrder(sid, Long.valueOf(id));
			model.addAttribute("returnOrder", returnOrder);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "order/r_order_auditBackGoods";
		
	}
	
	/**
	 * 退单退货审核
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/auditBackGoodsDo")
	@ResponseBody
	public JsonMsg auditBackGoodsDo(ReturnOrder returnOrder){
		JsonMsg jsonMsg = new JsonMsg();
		long sid =1001;
		if(null != returnOrder){
			try {
				Long roId = returnOrder.getId();
				String backmoneystatus = returnOrder.getBackmoneystatus();
				if(null != roId && backmoneystatus !=null && backmoneystatus.trim().length() > 0){
					returnOrderAPI.editReturnOrder(sid, roId,  returnOrder.getBackmoneystatus());
					jsonMsg.setSuccess(true);
					jsonMsg.setMsg("退单审核成功！");
				}else{
					jsonMsg.setSuccess(false);
					jsonMsg.setMsg("退单审核失败！");
				}
				
			} catch (ApiException e) {
				jsonMsg.setSuccess(false);
				jsonMsg.setMsg("退单审核失败！");
			}
			
		}else{
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("退单审核失败！");
		}
		return jsonMsg;
		
	}
	
}
