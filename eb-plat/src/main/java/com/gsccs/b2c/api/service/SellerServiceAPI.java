package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.pay.service.PayService;
import com.gsccs.b2c.plat.seller.model.SellerAccount;
import com.gsccs.b2c.plat.seller.service.SellerService;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.domain.trade.PayArgs;
import com.gsccs.eb.api.exception.ApiException;

public class SellerServiceAPI implements SellerServiceI {

	@Autowired
	private ShopService storeService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private PayService payService;

	@Override
	public Account getSeller(Long userId) throws ApiException {
		Account user = new Account();
		SellerAccount seller = sellerService.findById(userId);
		user.setUserId(seller.getId());
		user.setNick(seller.getName());
		return user;
	}

	@Override
	public Account getSeller(String account) throws ApiException {
		if (null == account || "".equals(account)) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		SellerAccount seller = sellerService.findByAccount(account);
		if (null != seller) {
			Account user = new Account();
			user.setUserId(seller.getId());
			user.setSiteId(seller.getStoreId());
			user.setNick(seller.getName());
			user.setAccount(seller.getAccount());
			user.setPassword(seller.getPwd());
			user.setSalt(seller.getSalt());
			boolean isLocked = seller.getSalt() == "1" ? true : false;
			user.setLocked(isLocked);
			return user;
		}
		return null;
	}

	@Override
	public void addStoreAccount(Account user) {
		if (null != user) {
			SellerAccount account = new SellerAccount();
			account.setAccount(user.getAccount());
			account.setName(user.getNick());
			account.setPwd(user.getPassword());
			account.setStoreId(user.getSiteId());
			account.setEmail(user.getEmail());
			sellerService.insert(account);
		}
	}

	@Override
	public List<PayArgs> getPayArgs(Long shopid) {
		PayArgs param = new PayArgs();
		param.setShopid(shopid);
		List<PayArgs> payargList = payService.queryPayArgs(param, 1,
				Integer.MAX_VALUE);
		return payargList;
	}

	@Override
	public PayArgs getPayArgs(String id) {
		return payService.getPayArgs(id);
	}

}
