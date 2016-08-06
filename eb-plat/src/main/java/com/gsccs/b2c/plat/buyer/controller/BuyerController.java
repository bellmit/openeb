package com.gsccs.b2c.plat.buyer.controller;

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

import com.gsccs.b2c.plat.buyer.service.BuyerService;
import com.gsccs.eb.api.domain.buyer.Buyer;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 会员管理
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	private BuyerService buyerService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Buyer param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, Model model) {
		List<Buyer> buyerlist = buyerService.getBuyerList(param, page, rows);
		model.addAttribute("buyerList", buyerlist);
		return "buyer/buyer-list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String buyerForm(Long id, Model model) {
		return "buyer/buyer-form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg buyerSave(ModelMap map, HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		return jsonMsg;
	}

}
