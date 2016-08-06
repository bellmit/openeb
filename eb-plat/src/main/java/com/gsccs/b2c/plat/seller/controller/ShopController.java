package com.gsccs.b2c.plat.seller.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.eb.api.domain.seller.Grade;
import com.gsccs.eb.api.domain.seller.Shop;

/**
 * 平台店铺管理
 * 
 * @创建人：x.j niu
 * @类名称：ShopController
 * @创建时间：2015年3月19日 上午9:55:22
 * 
 */
@Controller
@RequestMapping("/store")
public class ShopController {

	@Resource
	private ShopService storeService;

	/**
	 * 店铺列表
	 * @param param
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @return
	 */
	@RequiresPermissions("store:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Shop param,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map) {
		List<Shop> storeList = storeService.find(param, "", currPage, pageSize);
		List<Grade> gradeList = storeService.findGradeList();

		map.put("storeList", storeList);
		map.put("gradeList", gradeList);
		return "seller/shop-list";
	}

	/**
	 * 店铺表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String storeForm(Long id, ModelMap map) {
		String view = "seller/shop-add";
		Shop shop = null;
		if (null != id) {
			view = "seller/shop-edit";
			shop = storeService.findById(id);
		}
		map.put("shop", shop);
		return view;
	}

	/**
	 * 店铺查看
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String storeView(Long id, ModelMap map) {
		Shop shop = storeService.findById(id);
		map.put("shop", shop);
		return "seller/shop-view";
	}

	/**
	 * 店铺信息保存
	 * @param map
	 * @param shop
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonMsg saveShop(ModelMap map, Shop shop) {
		JsonMsg json = new JsonMsg();
		try {
			if (null == shop) {
				json.setMsg("保存失败");
				json.setSuccess(false);
				return json;
			}
			storeService.saveShop(shop);
			json.setSuccess(true);
			json.setMsg("保存成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("保存失败");
			e.printStackTrace();
		}
		return json;
	}
}
