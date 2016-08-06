package com.gsccs.b2c.plat.deliver.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.common.service.AreaService;
import com.gsccs.b2c.plat.deliver.service.DeliverService;
import com.gsccs.eb.api.domain.deliver.Corp;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 快递公司管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/deliver/corp")
public class DeliverCorpController {

	@Autowired
	private AreaService areaService;
	@Autowired
	private DeliverService deliverService;

	@RequiresPermissions("deliver:view")
	@RequestMapping(method = RequestMethod.GET)
	public String corpList(
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Corp param) {
		List<Corp> corpList = deliverService.find(param, "sort", currPage,
				pageSize, true);
		map.addAttribute("corpList", corpList);
		return "deliver/corp_list";
	}

	@RequiresPermissions("deliver:view")
	@RequestMapping(value="/view",method = RequestMethod.GET)
	public String corpForm(Integer id, ModelMap map) {
		Corp deliverCorp = null;
		String view = "deliver/corp_add";
		if (null != id) {
			view = "deliver/corp_edit";
			deliverService.getCorp(id);
		}
		map.addAttribute("deliverCorp", deliverCorp);
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg corpSave(ModelMap map, Corp deliver) {
		JsonMsg jsonMsg = new JsonMsg();

		return jsonMsg;
	}

}
