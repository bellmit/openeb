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
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.Type;

/**
 * 产品管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TypeService typeService;

	@RequiresPermissions("goods:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "goods/product_list";
	}

	@RequiresPermissions("goods:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " ordernum ") String order,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			Product param, HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<Product> list = goodsService.getProducts(param, order, page, rows);
		datagrid.setRows(list);
		datagrid.setTotal(Long.valueOf(30));
		return datagrid;
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String productForm(Long id, Model model) {
		String view="goods/product_edit";
		if (null!=id){
			view = "goods/product_edit";
		}
		
		Type type = typeService.getType(1005l);
		model.addAttribute("type", type);
		return view;
	}
	
	@RequiresPermissions("goods:update")
	@RequestMapping(value = "/{pid}/update", method = RequestMethod.POST)
	public String update(@PathVariable("pid") Long pid, Product product,
			RedirectAttributes redirectAttributes) {
		//brandService.update(brand);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/product";
	}

	
}
