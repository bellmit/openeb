package com.gsccs.b2c.plat.common.service;

import com.gsccs.eb.api.domain.base.Account;

/**
 */
public interface AccountService {
	
	public Long addAccount(Long sid, Account account);

	public Account loginAccount(Long sid, String account, String pwd);

	public Account getAccount(Long uid, Long sid);
	
	public Account getAccount(Long sid, String account);

	
}
