package com.gsccs.b2c.store.service;

import com.gsccs.eb.api.domain.base.Account;


public interface SellerService {

	public Account getSeller(long uid, long sid);

}
