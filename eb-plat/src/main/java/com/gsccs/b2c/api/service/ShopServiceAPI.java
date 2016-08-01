package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.Navigation;
import com.gsccs.eb.api.exception.ApiException;


public class ShopServiceAPI implements ShopServiceI {

	@Autowired
	private StoreService storeService;
	
	@Override
	public Shop getShop(Long sid) throws ApiException {
		if(sid == null){
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		
		Store store = storeService.findById(sid);
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
		Store store  = storeService.findById(sid);
		if(null != store){
			store.setId(sid);
			store.setStockalertnum(stockalertnum);
			storeService.update(store);
		}
	}

	
	@Override
	public List<Navigation> getStoreNav(Long sid) {
		return storeService.findStoreNavs(sid);
	}

}
