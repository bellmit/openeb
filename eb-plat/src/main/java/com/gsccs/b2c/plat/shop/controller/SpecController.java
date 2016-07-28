package com.gsccs.b2c.plat.shop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.shop.service.SpecService;
import com.gsccs.eb.api.domain.goods.Specific;

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
	public String list() {
		return "goods/spec_list";
	}

	@RequiresPermissions("spec:view")
	@RequestMapping(value = "/datagrid")
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Specific spec, HttpServletRequest request) {
		List<Specific> specList = specService.getSpecList(spec, order,
				currPage, pageSize);
		int totalCount = specService.count(spec);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(specList);
		datagrid.setTotal(Long.valueOf(totalCount));
		return datagrid;
	}

	@RequiresPermissions("spec:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("op", "新增");
		return "goods/spec_edit";
	}

	@RequiresPermissions("spec:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Specific spec, RedirectAttributes redirectAttributes) {
		if (null != spec) {
			specService.addSpecific(spec);
		}
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/spec";
	}

	@RequiresPermissions("spec:update")
	@RequestMapping(value = "/{specId}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("specId") Long specId,
			Model model) {
		model.addAttribute("spec", specService.getSpec(specId));
		model.addAttribute("op", "修改");
		return "goods/spec_edit";
	}

	@RequiresPermissions("spec:update")
	@RequestMapping(value = "/{specId}/update", method = RequestMethod.POST)
	public String update(Specific spec, RedirectAttributes redirectAttributes) {
		specService.updateSpecific(spec);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/spec";
	}

}
