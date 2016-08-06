package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.domain.site.Navigation;
import com.gsccs.eb.api.exception.ApiException;

public class ShopServiceAPI implements ShopServiceI {

	@Autowired
	private ShopService storeService;

	@Override
	public Shop getShop(Long sid) throws ApiException {
		if (sid == null) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		return storeService.findById(sid);
	}

	@Override
	public void editStore(Long sid, Integer stockalertnum) throws ApiException {
		Shop store = storeService.findById(sid);
		if (null != store) {
			store.setId(sid);
			store.setStockalertnum(stockalertnum);
			storeService.saveShop(store);
		}
	}

	@Override
	public List<Navigation> getStoreNav(Long sid) {
		return storeService.findShopNavs(sid);
	}

}
