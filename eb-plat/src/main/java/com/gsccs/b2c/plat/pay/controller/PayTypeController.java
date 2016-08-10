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
import com.gsccs.eb.api.domain.trade.PayType;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 商家支付参数配置
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/paytype")
public class PayTypeController {

	@Autowired
	private PayService payService;

	/**
	 * 支付方式列表
	 * 
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @param param
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String payTypeList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, ModelMap map,
			PayType param) {
		List<PayType> payTypes = payService
				.queryPayTypes(param, page, pagesize);
		map.put("payTypeList", payTypes);
		return "trade/paytype_list";
	}

	/**
	 * 支付方式表单
	 * 
	 * @param id
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String payTypeForm(String id, ModelMap map,
			HttpServletRequest request) {
		PayType payType = null;
		if (StringUtils.isNotEmpty(id)) {
			payType = payService.getPayType(id);
		}
		map.put("payType", payType);
		return "trade/paytype_form";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonMsg paytypeSave(PayType payType, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == payType) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		payService.savePayType(payType);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

}
