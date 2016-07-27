package com.gsccs.b2c.plat.seller.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.StoreCate;
import com.gsccs.b2c.plat.shop.service.CategoryService;

/**
 * 商城类目树管理
 * 
 * @author think
 * 
 */
@Controller
@RequestMapping("/storecate")
public class StoreCateController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "store/store-cate";
	}

	/**
	 * 获取商城已选类目
	 * 
	 * @param store
	 * @param map
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/checkedCates", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg checkedCates(Long storeId, ModelMap map, HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		try{
			StoreCate storeCate = categoryService.findStoreCateIds(storeId);
			jsonMsg.setSuccess(true);
			jsonMsg.setData(storeCate);
		}catch(Exception e){
			jsonMsg.setSuccess(false);
			jsonMsg.setMsg("获取商城类目失败。");
		}
		return jsonMsg;
	}
	

	/**
	 * 更新商城类目列表
	 * @param map
	 * @param storeId
	 * @param cateids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public JsonMsg update(ModelMap map, Long storeId,String cateids) {
		JsonMsg json = new JsonMsg();
		try {
			if (null != storeId){
				categoryService.addStoreCate(storeId, cateids);
			}
			json.setSuccess(true);
			json.setMsg("商城类目列表更新成功！");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("商城类目列表更新失败");
			e.printStackTrace();
		}
		return json;
	}
	
	
}
