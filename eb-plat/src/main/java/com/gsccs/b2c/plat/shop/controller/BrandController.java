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

	
	@RequiresPermissions("brand:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(){
		return "brand/list";
	}
	
	
	@RequiresPermissions("brand:view")
	@RequestMapping(value = "/datagrid",method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(@RequestParam(defaultValue = " orderNum ") String order,
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

	
	@RequiresPermissions("brand:create")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String showCreateForm(Model model) {
		model.addAttribute("op", "新增");
		return "brand/edit";
	}

	@RequiresPermissions("brand:create")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Brand brand, RedirectAttributes redirectAttributes) {
		if (null != brand) {
			brandService.add(brand);
		}
		redirectAttributes.addFlashAttribute("msg", "新增成功");
		return "redirect:/brand";
	}

	@RequiresPermissions("brand:update")
	@RequestMapping(value = "/{brandId}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("brandId") Long brandId,
			Model model) {
		model.addAttribute("brand", brandService.findById(brandId));
		model.addAttribute("op", "修改");
		return "brand/edit";
	}

	@RequiresPermissions("brand:update")
	@RequestMapping(value = "/{brandId}/update", method = RequestMethod.POST)
	public String update(Brand brand, RedirectAttributes redirectAttributes) {
		brandService.update(brand);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/brand";
	}

}
