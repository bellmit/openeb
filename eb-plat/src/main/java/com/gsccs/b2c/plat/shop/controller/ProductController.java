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
import com.gsccs.b2c.plat.shop.model.ProductT;
import com.gsccs.b2c.plat.shop.service.BrandService;
import com.gsccs.b2c.plat.shop.service.GoodsService;

/**
 * 平台产品管理
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

	@RequiresPermissions("goods:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "goods/product_list";
	}

	@RequiresPermissions("goods:view")
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			ProductT pt, HttpServletRequest request) {

		Long sid = Long.valueOf(1001), cateId = null;
		String title = null, barcode = null, state = null;String approvestatus=null;
		Double maxPrice = null, minPrice = null, maxSaleNum = null, minSaleNum = null, maxStoreNum = null, minStoreNum = null;
		if (null != pt) {
			// sid = pt.getSite();
			title = pt.getTitle();
		}
		
		List<ProductT> prodList = null;
		int totalCount = 0;
		/*List<ProductT> prodList = goodsService.getProducts(sid, title, barcode,
				cateId, maxPrice, minPrice, maxSaleNum, minSaleNum,
				maxStoreNum, minStoreNum, state, approvestatus,order, currPage, pageSize,
				true);
		int totalCount = goodsService.count(sid, title, barcode, cateId,
				maxPrice, minPrice, maxSaleNum, minSaleNum, maxStoreNum,
				minStoreNum, state);*/
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(prodList);
		datagrid.setTotal(Long.valueOf(totalCount));
		return datagrid;
	}
	
	@RequiresPermissions("goods:update")
	@RequestMapping(value = "/{sid}/{pid}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("sid") Long sid,@PathVariable("pid") Long pid, Model model) {
		model.addAttribute("product", goodsService.getProduct(sid, pid, false));
		model.addAttribute("op", "修改");
		return "goods/product_edit";
	}
	
	@RequiresPermissions("goods:update")
	@RequestMapping(value = "/{sid}/{pid}/update", method = RequestMethod.POST)
	public String update(@PathVariable("pid") Long pid, ProductT product,
			RedirectAttributes redirectAttributes) {
		//brandService.update(brand);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/product";
	}

	
}
