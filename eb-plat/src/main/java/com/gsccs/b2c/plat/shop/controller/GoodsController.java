package com.gsccs.b2c.plat.shop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.common.service.AreaService;
import com.gsccs.b2c.plat.shop.model.GoodsForm;
import com.gsccs.b2c.plat.shop.service.BrandService;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.eb.api.domain.base.Area;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.goods.Goods;
import com.gsccs.eb.api.domain.goods.Sku;
import com.gsccs.eb.api.domain.goods.SkuSpec;
import com.gsccs.eb.api.domain.goods.Type;
import com.gsccs.eb.api.utils.JsonMsg;

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
	@Autowired
	private AreaService areaService;

	
	@RequiresPermissions("goods:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int rows, ModelMap map,
			Goods param) {
		List<Goods> list = goodsService.getGoodsList(param, "", page, rows);
		map.addAttribute("productList", list);
		return "goods/goods_list";
	}

	@RequestMapping(value = "/checkcate", method = RequestMethod.GET)
	public String checkcate(Model model) {
		String view = "goods/goods_checkcate";
		List<Category> categoryList = categoryService.queryCateList(1001l, 0l);
		model.addAttribute("categoryList", categoryList);
		return view;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String goodsForm(Long cateid, Model model) {
		Category category = null;
		Type type = null;
		String view = "goods/goods_add";
		if (null == cateid) {
			return "redirect:/goods/checkcate";
		} else {
			category = categoryService.findById(cateid);
			if (null != category) {
				type = typeService.getType(category.getTypeId());
			}
		}

		List<Area> areaList = areaService.queryByParId(0);
		model.addAttribute("category", category);
		model.addAttribute("type", type);
		model.addAttribute("areaList", areaList);
		return view;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String goodsEdit(Long id, Model model) {
		String view = "goods/goods_edit";
		if (null == id) {
			return "redirect:/goods/checkcate";
		}
		Goods goods = goodsService.getGoods(id);
		List<Sku> skuList = goodsService.findSkuList(id);
		Type type = typeService.getType(1005l);

		model.addAttribute("type", type);
		model.addAttribute("goods", goods);
		model.addAttribute("skuList", skuList);
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/addsave", method = RequestMethod.POST)
	public JsonMsg goodsAdd(GoodsForm goodsForm) {
		JsonMsg jsonMsg = new JsonMsg();
		if(null == goodsForm){
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		Goods product = new Goods();
		product.setTitle(goodsForm.getTitle());
		product.setTypeid(goodsForm.getTypeid());
		product.setCateid(goodsForm.getCateid());
		product.setBrandid(goodsForm.getBrandid());
		List<Sku> skuList = sku(goodsForm);
		goodsService.addGoods(product, skuList);
		return jsonMsg;
	}

	@ResponseBody
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String goodsUpdate(GoodsForm goods) {
		if (null != goods) {
			String specVals = goods.getGoodsSpec();
			JSONObject jsonObject = JSON.parseObject(specVals);
			Iterator<String> its = jsonObject.keySet().iterator();
			while (its.hasNext()) {
				String key = its.next();
				System.out.println(key + " " + jsonObject.getString(key));
			}
		}
		return "redirect:/product";
	}

	
	@RequestMapping(value = "/validName", method = RequestMethod.POST)
	@ResponseBody
	public Boolean validName(String name) {
		return true;
	}
	
	
	private List<Sku> sku(GoodsForm goodsForm){
		List<Sku> skuList = new ArrayList<Sku>();
		
		String skuStr = goodsForm.getSpecJson();
		JSONArray skuArray = JSON.parseArray(skuStr);
		for(int i=0;i<skuArray.size();i++){
			Sku sku = new Sku();
			JSONObject skuobj = skuArray.getJSONObject(i);
			sku.setPrice(skuobj.getDouble("specGoodsPrice"));
			sku.setStorenum(skuobj.getInteger("specGoodsStorage"));
			System.out.println(skuobj.get("specName") +"|"+skuobj.get("specGoodsPrice")+"|");
			
			String specstr = skuobj.getString("specName");
			String specvalstr = skuobj.getString("specGoodsSpec");
			JSONObject specobj = JSON.parseObject(specstr);
			JSONObject specvalobj = JSON.parseObject(specvalstr);
			
			Iterator<String> specits = specobj.keySet().iterator();
			Iterator<String> specvalits = specvalobj.keySet().iterator();
			List<SkuSpec> specList = new ArrayList<SkuSpec>();
			while (specvalits.hasNext()) {
				String specid = specits.next();
				String specvalid = specvalits.next();
				SkuSpec skuSpec = new SkuSpec();
				skuSpec.setSpecid(Long.valueOf(specid));
				skuSpec.setSpecvalid(Long.valueOf(specvalid));
				specList.add(skuSpec);
			}
			//specjson
			sku.setSpecids(skuobj.getString("specName"));
			//skuspecjson
			sku.setSpecstr(skuobj.getString("specGoodsSpec"));
			sku.setSpecList(specList);
			skuList.add(sku);
		}
		
		return skuList;
	}

}
