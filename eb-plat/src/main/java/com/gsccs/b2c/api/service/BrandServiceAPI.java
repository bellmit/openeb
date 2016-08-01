package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.service.BrandService;
import com.gsccs.eb.api.domain.goods.Brand;
import com.gsccs.eb.api.exception.ApiException;

public class BrandServiceAPI implements BrandServiceI {

	@Autowired
	private BrandService brandService;
	
	@Autowired
	private StoreService storeService;

	@Override
	public Brand getBrand(Long id) {
		return brandService.findById(id);
	}

	@Override
	public List<Brand> getBrands(Long sid, int currPage, int pageSize) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Store store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		List<Brand> list = brandService
				.findStoreBrand(sid, currPage, pageSize, true);
		return list;
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
