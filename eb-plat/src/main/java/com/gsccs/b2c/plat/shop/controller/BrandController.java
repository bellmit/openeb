package com.gsccs.b2c.plat.shop.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.shop.service.BrandService;
import com.gsccs.eb.api.domain.goods.Brand;

/**
 * 平台品牌管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	// @RequiresPermissions("brand:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = " orderNum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Brand brand) {

		List<Brand> brandList = brandService.find(brand, order, currPage,
				pageSize, true);
		map.addAttribute("brandList", brandList);
		return "goods/brand-list";
	}

	// @RequiresPermissions("brand:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Brand brand, HttpServletRequest request) {

		List<Brand> brandList = brandService.find(brand, order, currPage,
				pageSize, true);
		int totalCount = brandService.count(brand);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(brandList);
		datagrid.setTotal(Long.valueOf(totalCount));
		return datagrid;
	}

	// @RequiresPermissions("brand:create")
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String brandForm(Long id, Model model) {
		String view = "goods/brand-add";
		if (null != id) {
			view = "goods/brand-edit";
			Brand brand = brandService.findById(id);
			model.addAttribute("brand", brand);
		}
		return view;
	}

	// @RequiresPermissions("brand:create")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String create(Brand brand, RedirectAttributes redirectAttributes) {
		if (null != brand) {
			brandService.add(brand);
		}
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/brand";
	}

}
