package com.gsccs.b2c.plat.pay.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.pay.service.PayService;
import com.gsccs.eb.api.domain.trade.PayArgs;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 平台支付方式配置
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/payargs")
public class PayArgsController {

	@Autowired
	private PayService payService;

	/**
	 * 支付参数列表
	 * 
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param param
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String payArgsList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, ModelMap map,
			PayArgs param) {
		List<PayArgs> payArgsList = payService.queryPayArgs(param, page,
				pagesize);
		map.put("payArgsList", payArgsList);
		return "trade/payargs_list";
	}

	/**
	 * 支付参数表单
	 * 
	 * @param id
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String payArgsForm(String id, ModelMap map,
			HttpServletRequest request) {
		PayArgs payArgs = null;
		if (StringUtils.isNotEmpty(id)) {
			payArgs = payService.getPayArgs(id);
		}
		map.put("payArgs", payArgs);
		return "trade/payargs_form";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonMsg payArgsSave(PayArgs payArgs, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == payArgs) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		payService.savePayArgs(payArgs);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
