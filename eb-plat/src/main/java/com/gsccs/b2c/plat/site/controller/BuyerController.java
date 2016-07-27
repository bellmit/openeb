package com.gsccs.b2c.plat.site.controller;

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

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.buyer.model.BuyerAccount;
import com.gsccs.b2c.plat.buyer.service.BuyerService;

/**
 * 
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController {

	@Autowired
	private BuyerService buyerService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		return "buyer/buyer-list";
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid buyerlist(@RequestParam(defaultValue = "1001") Long sid,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<BuyerAccount> buyerlist = this.buyerService.getAllAcountBySid(Long
				.valueOf(sid));
		datagrid.setRows(buyerlist);
		datagrid.setTotal(Long.valueOf(0));
		return datagrid;
	}

	@RequestMapping(value = "/dataform", method = RequestMethod.GET)
	public String dataform(Model model) {
		return "buyer/buyer-form";
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid create(@RequestParam(defaultValue = "1001") Long sid,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<BuyerAccount> buyerlist = this.buyerService.getAllAcountBySid(Long
				.valueOf(sid));
		datagrid.setRows(buyerlist);
		datagrid.setTotal(Long.valueOf(0));
		return datagrid;
	}

}
