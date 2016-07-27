package com.gsccs.b2c.plat.seller.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.StoreT;

/**
 * 平台店铺管理
 * 
 * @创建人：x.j niu
 * @类名称：StoreController
 * @创建时间：2015年3月19日 上午9:55:22
 * 
 */

@Controller
@RequestMapping("/store")
public class StoreController {

	@Resource
	private StoreService storeService;

	@RequiresPermissions("store:view")
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "store/store-list";
	}

	/**
	 * 店铺列表信息
	 * 
	 * @param store
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public Datagrid storeList(StoreT store,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<StoreT> storeList = storeService.find(store, order, currPage,
				pageSize);
		int count = storeService.count(store);
		datagrid.setRows(storeList);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 店铺表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/dataform")
	public String storeEdit(Long id, ModelMap map) {
		StoreT store = null;
		if (null != id) {
			store = storeService.findById(id);
		}
		map.put("store", store);
		return "store/store-form";
	}

	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JsonMsg create(ModelMap map, StoreT store) {
		JsonMsg json = new JsonMsg();
		try {
			storeService.insert(store);
			json.setSuccess(true);
			json.setMsg("商城创建成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("商城创建失败");
			e.printStackTrace();
		}
		return json;
	}
}
