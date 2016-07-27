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
import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.service.BrandService;
import com.gsccs.b2c.plat.shop.service.GoodsService;

/**
 * 平台品牌管理
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private BrandService brandService;
	@Autowired
	private GoodsService goodsService;

	@RequiresPermissions("goods:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "goods/goods_list";
	}

	@RequiresPermissions("goods:view")
	@RequestMapping(value = "/{pid}/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid list(
			@RequestParam(defaultValue = " orderNum ") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			@PathVariable("pid") Long pid, HttpServletRequest request) {

		List<GoodsT> goodsList = null;
				//goodsService.getGoods(pid, currPage, pageSize);
		int totalCount = 0;
		//goodsService.count(pid);
		Datagrid datagrid = new Datagrid();
		/*List<GoodsT> goodsList = goodsService.getGoods(pid, currPage, pageSize);
		int totalCount = goodsService.count(pid);
		Datagrid datagrid = new Datagrid();
		datagrid.setRows(goodsList);
		datagrid.setTotal(Long.valueOf(totalCount));*/
		return datagrid;
	}

	@RequiresPermissions("goods:update")
	@RequestMapping(value = "/{goodsId}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("goodsId") Long goodsId,
			Model model) {
		// model.addAttribute("brand", brandService.findById(brandId));
		// model.addAttribute("op", "修改");
		return "goods/goods_edit";
	}

	@RequiresPermissions("goods:update")
	@RequestMapping(value = "/{goodsId}/update", method = RequestMethod.POST)
	public String update(GoodsT goods, RedirectAttributes redirectAttributes) {
		// brandService.update(brand);
		redirectAttributes.addFlashAttribute("msg", "修改成功");
		return "redirect:/goods";
	}

}
