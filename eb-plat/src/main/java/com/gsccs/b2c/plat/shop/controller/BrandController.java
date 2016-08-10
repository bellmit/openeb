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
import com.gsccs.eb.api.utils.JsonMsg;

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
	public String list(@RequestParam(defaultValue = " ordernum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Brand brand) {
		brand.setState("1");
		List<Brand> brandList = brandService.find(brand, order, currPage,
				pageSize, true);
		map.addAttribute("brandList", brandList);
		return "goods/brand-list";
	}

	// @RequiresPermissions("brand:view")
	@RequestMapping(value = "/auditlist", method = RequestMethod.GET)
	public String auditList(
			@RequestParam(defaultValue = " ordernum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			Brand brand, HttpServletRequest request) {
		brand.setState("0");
		List<Brand> brandList = brandService.find(brand, order, currPage,
				pageSize, true);
		int totalCount = brandService.count(brand);
		map.addAttribute("brandList", brandList);
		return "goods/brand-auditlist";
	}

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
	
	@RequestMapping(value = "/audit", method = RequestMethod.GET)
	public String brandAudit(Long id, Model model) {
		String view = "goods/brand-audit";
		if (null != id) {
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
	
	
	@RequestMapping(value = "/validName", method = RequestMethod.POST)
	@ResponseBody
	public Boolean validName(String name) {
		return true;
	}

}
