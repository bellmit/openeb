package com.gsccs.b2c.plat.site.controller;

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
import com.gsccs.b2c.plat.buyer.service.BuyerService;

/**
 * 楼层管理
 */
@Controller
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private BuyerService buyerService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		
		return "site/floor-list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String floorForm(Long id,Model model) {
		String view =  "site/floor-add";
		if (null!=id){
			 view = "site/floor-edit";
		}
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid create(@RequestParam(defaultValue = "1001") Long sid,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		
		datagrid.setTotal(Long.valueOf(0));
		return datagrid;
	}

}
