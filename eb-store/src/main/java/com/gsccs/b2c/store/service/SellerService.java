package com.gsccs.b2c.store.service;

import com.gsccs.b2c.api.domain.User;

public interface SellerService {

	public User getSeller(long uid, long sid);

}
