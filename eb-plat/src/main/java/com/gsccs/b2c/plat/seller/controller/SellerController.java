package com.gsccs.b2c.plat.seller.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.gsccs.b2c.plat.bass.Datagrid;
import com.gsccs.b2c.plat.bass.JsonMsg;
import com.gsccs.b2c.plat.seller.service.SellerService;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.SellerAccount;

/**
 * 商城卖家管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private SellerService sellerService;

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "store/seller-list";
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
	public Datagrid sellerList(SellerAccount account,
			@RequestParam(defaultValue = "") String order,
			@RequestParam(defaultValue = "1") int currPage,
			@RequestParam(defaultValue = "10") int pageSize, ModelMap map,
			HttpServletRequest request) {
		Datagrid datagrid = new Datagrid();
		List<SellerAccount> sellerlist = sellerService.find(account, order,
				currPage, pageSize);
		int count = sellerService.count(account);
		datagrid.setRows(sellerlist);
		datagrid.setTotal(Long.valueOf(count));
		return datagrid;
	}

	/**
	 * 卖家表单
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/dataform")
	public String dataform(Long id,Long storeId,ModelMap map) {
		SellerAccount account = null;
		if (null != id) {
			account = sellerService.findById(id);
			storeId = account.getStoreId();
		}
		map.put("seller", account);
		map.put("storeId", storeId);
		return "store/seller-form";
	}

	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JsonMsg create(ModelMap map, SellerAccount account) {
		JsonMsg json = new JsonMsg();
		try {
			if (null != account && StringUtils.isNotEmpty(account.getAccount())){
				List<SellerAccount> accounts = sellerService.find(account);
				if (null== accounts || accounts.size()<=0){
					sellerService.insert(account);
					json.setSuccess(true);
					json.setMsg("卖家帐号创建成功！");
					return json;
				}else{
					json.setSuccess(false);
					json.setMsg("卖家帐号 "+account.getAccount()+"已存在，请不要重复创建。");
					return json;
				}
			}else{
				json.setSuccess(false);
				json.setMsg("卖家帐号创建失败。");
				return json;
			}
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("卖家帐号创建失败");
			e.printStackTrace();
		}
		return json;
	}
	
	
	/**
	 * 平台商家统计分析
	 * @param map
	 * @param account
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/statist", method = RequestMethod.POST)
	public JSONObject statist(ModelMap map) {
		JSONObject json = new JSONObject();
		try {
			storeService.storeStatist();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
}
