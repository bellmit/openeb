package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.b2c.plat.shop.service.CategoryService;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 类目服务接口
 * 
 * @author x.d zhang
 * 
 */
public class CateServiceAPI implements CateServiceI {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShopService storeService;

	@Override
	public JSONArray getAllCategorys(String state) {
		return categoryService.findAll(state);
	}

	@Override
	public Category getCate(Long cateId) {
		Category t = categoryService.findById(cateId);
		return t;
	}

	@Override
	public List<Category> getRootCates(Long siteId) {
		List<Category> list = categoryService.queryCateList(siteId, null);
		return list;
	}

	@Override
	public JSONArray getSiteCates(Long sid) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		return categoryService.findBySite(sid);
	}

	@Override
	public JSONArray getStoreCates(Long storeId) throws ApiException {
		if (null == storeId) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = storeService.findById(storeId);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		return categoryService.findByStore(storeId);
	}

	@Override
	public JSONArray getStoreCates(Long siteId, Long parid) throws ApiException {
		return categoryService.findByStore(siteId, parid);
	}

}
