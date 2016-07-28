package com.gsccs.b2c.store.deliver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.service.DeliverServiceI;
import com.gsccs.b2c.store.base.JsonMsg;
import com.gsccs.eb.api.domain.deliver.DeliverType;
import com.gsccs.eb.api.domain.deliver.DlyCorp;
import com.gsccs.eb.api.exception.ApiException;
import com.gsccs.eb.api.utils.Datagrid;

/**
 * 物流管理控制类
 * @author niu x j
 *
 */
@Controller
@RequestMapping("/logistics")
public class LogisticsController {
	
	@Autowired 
	private DeliverServiceI logisticsServiceAPI;

	/**
	 * 配送方式列表
	 * @param order
	 * @param page
	 * @param rows
	 * @param map
	 * @param deliverType
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/deliverTypeList")
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			DeliverType deliverType, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		Datagrid datagrid = new Datagrid();
		List<DeliverType> dtList = logisticsServiceAPI.findDeliverTypes(sid);
		deliverType.setSiteid(sid);
		int count = logisticsServiceAPI.count(deliverType);
		datagrid.setRows(dtList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
	

	/**
	 * 配送方式删除 
	 * @param ids
	 * @param status
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping("/DeliverTypeDel")
	@ResponseBody
	public JsonMsg DeliverTypeDel(String ids, HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=ids ){
			logisticsServiceAPI.delDeliverType(ids);
			msg.setSuccess(true);
			msg.setMsg("配送方式删除成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("配送方式删除失败!");
		}
		
		return msg;
	}
	
	/**
	 * 跳转到添加配送方式页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/DeliverTypeAdd")
	public String DeliverTypeAdd(Model model,HttpServletRequest request){
		long sid = (Long) request.getSession().getAttribute("siteId");
		List<DlyCorp> dlyCorys = logisticsServiceAPI.findCorps();
		model.addAttribute("dlyCorys", dlyCorys);
		return "logistics/deliver_type_add";
	}
	
	/**
	 * 添加配送方式
	 * @param dt
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value="/DeliverTypeAddDo",method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg DeliverTypeAddDo(DeliverType deliverType , HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=deliverType  ){
			deliverType.setSiteid(sid);
		    logisticsServiceAPI.saveDeliverType(deliverType);
			msg.setSuccess(true);
			msg.setMsg("保存配送方式成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("保存配送方式失败!");
		}
		
		return msg;
	}
	/**
	 * 跳转到修改配送方式页面
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping("/DeliverTypeEdit")
	public String DeliverTypeDdit(String  id, Model model,HttpServletRequest request) throws ApiException {
		DeliverType dt = null;
		if(null !=id && id.trim().length() >0){
			dt = logisticsServiceAPI.findDeliverType(id);
		}
		 
		List<DlyCorp> dlyCorys = logisticsServiceAPI.findCorps();
		model.addAttribute("dlyCorys", dlyCorys);
		model.addAttribute("dt", dt);
		return "logistics/deliver_type_edit";
		
	}
	/**
	 * 修改配送方式
	 * @param dt
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping("/DeliverTypeEditDo")
	@ResponseBody
	public JsonMsg DeliverTypeEditDo(DeliverType dt , HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		JsonMsg msg = new JsonMsg();
		if(null !=dt  ){
			dt.setSiteid(sid);
		    logisticsServiceAPI.updateDeliverType(dt);
			msg.setSuccess(true);
			msg.setMsg("配送方式修改成功!");
		}else{
			msg.setSuccess(false);
			msg.setMsg("配送方式修改失败!");
		}
		
		return msg;
	}
}
