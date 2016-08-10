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

import com.gsccs.b2c.plat.pay.service.PayService;
import com.gsccs.eb.api.domain.trade.PayType;

/**
 * 支付记录管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/paynote")
public class PayNoteController {

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
		return "trade/paynote_list";
	}

	/**
	 * 支付方式表单
	 * 
	 * @param id
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String payTypeForm(String id, ModelMap map,
			HttpServletRequest request) {
		PayType payType = null;
		if (StringUtils.isNotEmpty(id)) {
			payType = payService.getPayType(id);
		}
		map.put("payType", payType);
		return "trade/paynote_view";
	}

}
