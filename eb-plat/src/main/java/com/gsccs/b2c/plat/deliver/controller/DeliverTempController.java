package com.gsccs.b2c.plat.deliver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import com.gsccs.b2c.plat.deliver.service.DeliverService;
import com.gsccs.eb.api.domain.deliver.Templet;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 物流类型管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/deliver/templet")
public class DeliverTempController {

	@Autowired
	private AreaService areaService;
	@Autowired
	private DeliverService deliverService;

	@RequiresPermissions("deliver:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Templet param) {
		List<Templet> templetList = deliverService.find(param, "", currPage,
				pageSize, true);
		map.addAttribute("templetList", templetList);
		return "deliver/templet-list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String templetForm(String id, ModelMap map) {
		Templet templet = null;
		String view = "deliver/templet-add";
		if (StringUtils.isNotEmpty(id)) {
			templet = deliverService.getType(id);
			view = "deliver/templet-edit";
		}
		map.addAttribute("templet", templet);
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg templetSave(Templet templet, ModelMap map) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == templet) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		deliverService.saveType(templet);
		return jsonMsg;
	}

}
