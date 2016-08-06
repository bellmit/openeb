package com.gsccs.b2c.plat.shop.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.shop.model.GoodsForm;
import com.gsccs.b2c.plat.shop.service.BrandService;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.goods.Product;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.goods.Type;

/**
 * 商品管理
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
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TypeService typeService;

	@RequiresPermissions("goods:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			Product param) {
		List<Product> list = goodsService.getProducts(param, "", page, rows);
		map.addAttribute("productList", list);
		return "goods/goods_list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String goodsForm(Long id, Model model) {
		String view = "goods/goods_add";
		Product goods = null;
		List<Sku> skuList = null;
		if (null != id) {
			view = "goods/goods_edit";
			goods = goodsService.getGoods(id);
			skuList = goodsService.getSkuList(id);
		}else{
			List<Category> categoryList = categoryService.queryCateList(1001l, 0l);
			model.addAttribute("categoryList", categoryList);
		}
		Type type = typeService.getType(1005l);
		
		model.addAttribute("type", type);
		model.addAttribute("goods", goods);
		model.addAttribute("skuList", skuList);
		return view;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String productSave(Product product) {

		return "redirect:/product";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String goodsUpdate(GoodsForm goods) {
		if (null != goods){
			String specVals = goods.getGoodsSpec();
			JSONObject jsonObject = JSON.parseObject(specVals);
			Iterator<String> its = jsonObject.keySet().iterator();
			while(its.hasNext()){
				String key = its.next();
				System.out.println(key+" "+jsonObject.getString(key));
			}
		}
		return "redirect:/product";
	}

}
