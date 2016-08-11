package com.gsccs.b2c.plat.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.auth.model.DictGroup;
import com.gsccs.b2c.plat.auth.model.DictItem;
import com.gsccs.b2c.plat.auth.model.User;
import com.gsccs.b2c.plat.auth.service.DictService;
import com.gsccs.b2c.plat.bass.Datagrid;


/**
 * 数据字典
 * @author x.d zhang
 *
 */
@Controller
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	@RequestMapping(value = "/dictgroup", method = RequestMethod.GET)
	public String dictgroup(DictGroup param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, ModelMap map,
			HttpServletRequest request) {
		List<DictGroup> dictgroupList = dictService.findGroupList(param, page, rows);
		map.put("dictgroupList", dictgroupList);
		return "auth/dictgroup-list";
	}
	
	
	@RequestMapping(value = "/dictitem", method = RequestMethod.GET)
	public String dictitem(DictItem param,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "20") int rows, ModelMap map,
			HttpServletRequest request) {
		List<DictItem> dictItemList = dictService.findItemList(param, page, rows);
		map.put("dictItemList", dictItemList);
		return "auth/dictitem-list";
	}

}
