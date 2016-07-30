package com.gsccs.b2c.plat.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.shop.service.SpecService;
import com.gsccs.eb.api.domain.goods.Specific;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 平台商品规格控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/spec")
public class SpecController {

	@Autowired
	private SpecService specService;

	@RequiresPermissions("spec:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Specific param,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map) {
		List<Specific> specList = specService
				.getSpecList(param, "", page, rows);
		int total = specService.count(param);
		map.put("page", page);
		map.put("rows", rows);
		map.put("specList", specList);
		map.put("total", total);
		return "goods/spec_list";
	}

	@RequiresPermissions("spec:view")
	@RequestMapping(value = "/checkSpecName")
	@ResponseBody
	public Boolean checkSpecName(String specname, HttpServletRequest request) {
		List<Specific> list = specService.queryBySpecName(specname);
		if (null == list || list.size() <= 0) {
			return true;
		}else{
		}
		return false;
	}

	@RequiresPermissions("spec:create")
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String specForm(Long id, Model model) {
		String view = "goods/spec_add";
		if (null != id) {
			Specific specific = specService.getSpec(id);
			view = "goods/spec_edit";
			model.addAttribute("spec", specific);
		}
		return view;
	}
	
	
	@RequiresPermissions("spec:delete")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String specDelete(Long id, Model model) {
		if (null != id) {
			specService.deleteSpecific(id);
		}
		return "goods/spec_list";
	}

	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String specSave(@RequestBody Specific spec, RedirectAttributes redirectAttributes) {
		if (null != spec) {
			if (null==spec.getId()){
				specService.addSpecific(spec);
			}else{
				specService.updateSpecific(spec);
			}
		}
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/spec";
	}

	
}
