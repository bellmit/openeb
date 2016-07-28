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
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.eb.api.domain.goods.Type;

/**
 * 平台商品类型控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/type")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@RequiresPermissions("type:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {

		return "goods/type_list";
	}

	@RequiresPermissions("type:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum  ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Type type, HttpServletRequest request) {

		List<Type> typeList = typeService.getTypeList(type, order, currPage,
				pageSize);
		int count = typeService.count(type);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(typeList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	@RequiresPermissions("type:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("op", "新增");
		return "goods/type_edit";
	}

	@RequiresPermissions("type:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Type type, RedirectAttributes redirectAttributes) {
		if (null != type) {
			typeService.addType(type);
		}
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/type";
	}

	@RequiresPermissions("type:update")
	@RequestMapping(value = "/{typeId}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("typeId") Long typeId,
			Model model) {
		model.addAttribute("type", typeService.getType(typeId));
		model.addAttribute("op", "修改");
		return "goods/type_edit";
	}

	@RequiresPermissions("type:update")
	@RequestMapping(value = "/{typeId}/update", method = RequestMethod.POST)
	public String update(Type type, RedirectAttributes redirectAttributes) {
		typeService.UpdateType(type);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/type";
	}

}
