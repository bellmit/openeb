package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.Brand;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.StoreT;
import com.gsccs.b2c.plat.shop.service.BrandService;

public class BrandServiceAPI implements BrandServiceI {

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private StoreService storeService;

	@Override
	public Brand getBrand(Long id) {
		com.gsccs.b2c.plat.shop.model.BrandT t = brandService.findById(id);
		if (null != t) {
			Brand brand = new Brand();
			brand.setId(t.getId());
			brand.setName(t.getName());
			brand.setDescription(t.getDescription());
			brand.setOrdernum(t.getOrdernum());
			return brand;
		}
		return null;
	}

	@Override
	public List<Brand> getBrands(Long sid, int currPage, int pageSize) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		List<Brand> result = null;
		List<com.gsccs.b2c.plat.shop.model.BrandT> list = brandService
				.findStoreBrand(sid, currPage, pageSize, true);
		if (null != list) {
			result = new ArrayList<Brand>();
			Brand brand = null;
			for (com.gsccs.b2c.plat.shop.model.BrandT t : list) {
				brand = new Brand();
				try {
					BeanUtils.copyProperties(brand, t);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				result.add(brand);
			}
		}
		return result;
	}

	@Override
	public void addBrand(Brand brand) {
		
	}

	@Override
	public void updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delBrand(Long id) {
		// TODO Auto-generated method stub
		
	}

}
