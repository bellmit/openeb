package com.gsccs.b2c.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.StoreNavT;
import com.gsccs.b2c.plat.shop.model.StoreT;
import com.gsccs.b2c.plat.utils.BeanUtilsEx;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.StoreNav;


public class ShopServiceAPI implements ShopServiceI {

	@Autowired
	private StoreService storeService;
	
	@Override
	public Shop getShop(Long sid) throws ApiException {
		if(sid == null){
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		
		StoreT store = storeService.findById(sid);
		if( null !=store){
			Shop shop = new Shop();
			shop.setSid(sid);
			shop.setTitle(store.getName());
			shop.setDomain(store.getDomain());
			shop.setStockalertnum(store.getStockalertnum());
			shop.setPicPath(store.getAdress());
			return shop;
		}
		return null;
	}
	
	

	@Override
	public void editStore(Long sid, Integer stockalertnum) throws ApiException {
		StoreT store  = storeService.findById(sid);
		if(null != store){
			store.setId(sid);
			store.setStockalertnum(stockalertnum);
			storeService.update(store);
		}
	}

	
	@Override
	public List<StoreNav> getStoreNav(Long sid) {
		List<StoreNav> result = new ArrayList<StoreNav>();
		List<StoreNavT> list = storeService.findStoreNavs(sid);
		if (null != list && list.size()>0){
			for (StoreNavT t:list){
				StoreNav nav = new StoreNav();
				BeanUtilsEx.copyProperties(nav, t);
				result.add(nav);
			}
		}
		return result;
	}

}
