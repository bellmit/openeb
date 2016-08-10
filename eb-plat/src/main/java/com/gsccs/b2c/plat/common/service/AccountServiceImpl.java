package com.gsccs.b2c.plat.common.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.auth.shiro.PasswordHelper;
import com.gsccs.b2c.plat.common.dao.AccountMapper;
import com.gsccs.b2c.plat.common.model.AccountExample;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.domain.buyer.Buyer;

/**
 * 
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountMapper accountMapper;

	// 会员注册
	@Override
	public Long addAccount(Long sid, Account account) {
		if (null != sid && null != account) {
			PasswordHelper pwdhelp = new PasswordHelper();
			pwdhelp.encryptPassword(account);
			accountMapper.insert(account);
			return account.getId();
		}
		return null;
	}

	// 会员登录
	@Override
	public Account loginAccount(Long sid, String account, String pwd) {
		return accountMapper.loginAccount(sid, account, pwd);
	}

	@Override
	public Account getAccount(Long sid, String account) {
		return accountMapper.selectByAccount(account, sid);
	}

	@Override
	public Account getAccount(Long uid, Long sid) {
		return accountMapper.selectByPrimaryKey(sid);
	}

	public void proSearchParam(Account area, AccountExample.Criteria criteria) {
		if (null != area) {

		}
	}

}
