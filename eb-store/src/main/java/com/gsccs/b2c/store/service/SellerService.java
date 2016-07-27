package com.gsccs.b2c.store.service;

import com.gsccs.b2c.api.domain.Account;


public interface SellerService {

	public Account getSeller(long uid, long sid);

}
