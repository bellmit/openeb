package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.Category;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.StoreT;
import com.gsccs.b2c.plat.shop.service.CategoryService;

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
	private StoreService storeService;

	@Override
	public JSONArray getAllCategorys(String state) {
		return categoryService.findAll(state);
	}

	@Override
	public Category getCate(Long cateId) {
		com.gsccs.b2c.plat.shop.model.CategoryT t = categoryService
				.findById(cateId);
		if (null != t) {
			Category c = new Category();
			try {
				BeanUtils.copyProperties(c, t);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return c;
		}
		return null;
	}

	@Override
	public List<Category> getRootCates(Long siteId) {
		List<Category> result = null;
		List<com.gsccs.b2c.plat.shop.model.CategoryT> list = categoryService
				.findByPar(null);
		if (null != list && list.size() > 0) {
			result = new ArrayList<Category>();
			Category cate;
			for (com.gsccs.b2c.plat.shop.model.CategoryT t : list) {
				cate = new Category();
				try {
					BeanUtils.copyProperties(cate, t);
					result.add(cate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public JSONArray getSiteCates(Long sid) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
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
		StoreT store = storeService.findById(storeId);
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
