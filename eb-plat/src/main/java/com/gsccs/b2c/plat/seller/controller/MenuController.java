package com.gsccs.b2c.plat.seller.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.seller.service.ShopMenuService;
import com.gsccs.eb.api.domain.seller.Menu;

/**
 * 店铺菜单管理
 * 
 */
@Controller
@RequestMapping("/shopmenu")
public class MenuController {

	@Resource
	private ShopMenuService shopMenuService;

	/**
	 * 店铺菜单列表
	 * 
	 * @param param
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @return
	 */
	@RequiresPermissions("store:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap map) {
		List<Menu> menuList = shopMenuService.findByParId(0l);
		map.put("menuList", menuList);
		return "seller/menu-list";
	}

	/**
	 * 子级列表
	 * 
	 * @param param
	 * @param currPage
	 * @param pageSize
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/child", method = RequestMethod.GET)
	public List<Menu> child(Long id) {
		List<Menu> menuList = shopMenuService.findByParId(id);
		return menuList;
	}

	/**
	 * 店铺菜单表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String storeForm(Long id, ModelMap map) {
		String view = "seller/menu-add";
		Menu menu = null;
		if (null != id) {
			view = "seller/menu-edit";
			menu = shopMenuService.getById(id);
		}
		map.put("menu", menu);
		return view;
	}

	/**
	 * 信息保存
	 * 
	 * @param map
	 * @param shop
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public JsonMsg saveMenu(ModelMap map, Menu menu) {
		JsonMsg json = new JsonMsg();
		try {
			if (null == menu) {
				json.setMsg("保存失败");
				json.setSuccess(false);
				return json;
			}
			shopMenuService.save(menu);
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
