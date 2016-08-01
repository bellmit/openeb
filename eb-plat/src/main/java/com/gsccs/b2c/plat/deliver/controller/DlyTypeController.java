package com.gsccs.b2c.plat.deliver.controller;

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

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.common.service.AreaService;
import com.gsccs.b2c.plat.deliver.model.Templet;
import com.gsccs.b2c.plat.deliver.service.DeliverService;

/**
 * 物流类型管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/dlytype")
public class DlyTypeController {

	@Autowired
	private AreaService areaService;
	@Autowired
	private DeliverService deliverService;

	@RequiresPermissions("deliver:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "logist/dlytype_list";
	}

	@RequiresPermissions("deliver:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Templet deliver, HttpServletRequest request) {

		List<Templet> brandList = deliverService.find(deliver, order,
				currPage, pageSize, true);
		int totalCount = deliverService.count(deliver);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(brandList);
		datagrid.setTotal(Long.valueOf(totalCount));
		return datagrid;
	}

}