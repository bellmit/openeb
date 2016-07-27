package com.gsccs.b2c.store.eval.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.domain.Datagrid;
import com.gsccs.b2c.api.domain.DeliverType;
import com.gsccs.b2c.api.domain.EvalItem;
import com.gsccs.b2c.api.domain.EvalModel;
import com.gsccs.b2c.api.domain.EvalType;
import com.gsccs.b2c.api.domain.JsonMsg;
import com.gsccs.b2c.api.domain.Product;
import com.gsccs.b2c.api.domain.Sku;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.EvalServiceI;

/**
 * 评论管理
 * @author niu x j
 *
 */
@Controller
@RequestMapping("/eval")
public class EvalController {
	
	@Autowired 
	private EvalServiceI evalServiceAPI;
	
	

	/**
	 * 评分项目列表显示
	 * @param order
	 * @param page
	 * @param rows
	 * @param map
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/EvalTypeList")
	@ResponseBody
	public JsonMsg list(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			 HttpServletRequest request) throws ApiException {
		JsonMsg msg = new JsonMsg();
		//long sid = (Long) request.getSession().getAttribute("siteId");
		List<EvalModel> evalMList = evalServiceAPI.getEvals();
		msg.setData(evalMList);
		msg.setSuccess(true);
		msg.setMsg("评论项目加载成功!");
		
		return msg;
	}
	
	// 保存评论项目
	@RequestMapping("/saveEval")
	@ResponseBody
	public JsonMsg saveEval(HttpServletRequest request, Product product, String[] evalArray) {
		JsonMsg msg = new JsonMsg();
		
		long siteId = (Long) request.getSession().getAttribute("siteId");
		if(null != evalArray){
			EvalType et = null;
			long etId = 0;
			String state = "1";
			String IsDefault = "0";
			for(String s : evalArray) {
				String[] evalValue = s.split(";");
				et = new EvalType();
				//保存评分项目
				et.setTitle(evalValue[0]);
				et.setIsdefault(IsDefault);
				et.setState(state);
				et.setSiteid(siteId);
				
				etId = evalServiceAPI.addEvalType(et);
				
				//保存打分项
				EvalItem ei = null;
				for (int i = 5; i > 0; i--) {
					ei = new EvalItem();
					ei.setSiteid(siteId);
					ei.setScore(i);
					ei.setContent(evalValue[i]);
					ei.setIsdefault(IsDefault);
					ei.setTypeid(etId);
					evalServiceAPI.addEvalItem(ei);
				}
			}
			
			msg.setMsg("评论数据保存成功");
			msg.setSuccess(true);
		}
		
		return msg;
	}
	
	
	public Datagrid list11(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			 HttpServletRequest request) throws ApiException {
		long sid = (Long) request.getSession().getAttribute("siteId");
		Datagrid datagrid = new Datagrid();
		List<EvalModel> evalMList = evalServiceAPI.getEvals();
//		List<DeliverType> dtList = logisticsServiceAPI.findDeliverTypes(sid);
//		deliverType.setSiteid(sid);
//		int count = logisticsServiceAPI.count(deliverType);
		datagrid.setRows(evalMList);
//		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}
}
