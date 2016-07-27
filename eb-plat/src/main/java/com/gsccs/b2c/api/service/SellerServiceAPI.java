package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.plat.seller.model.SellerPay;
import com.gsccs.b2c.plat.seller.service.PayService;
import com.gsccs.b2c.plat.seller.service.SellerService;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.SellerAccount;
import com.gsccs.eb.api.domain.trade.Payment;
import com.gsccs.eb.api.exception.ApiException;

public class SellerServiceAPI implements SellerServiceI {

	@Autowired
	private StoreService storeService;
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
	
	

	public List<Payment> getStorePays(String storeid) {
		List<Payment> list = null;
		List<SellerPay> pays = payService.getPayments(storeid);
		if (null != pays) {
			list = new ArrayList<Payment>();
			Payment payment;
			for (int i = 0; i < pays.size(); i++) {
				payment = new Payment();
				try {
					BeanUtils.copyProperties(payment, pays.get(i));
					list.add(payment);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public Payment getAlipay(String storeid) {
		Payment payment = null;
		SellerPay sellerPay = payService.getPaymentByType(storeid,
				APIConst.PAYMENT_TYPE_ALIPAY);
		if (null != sellerPay) {
			try {
				BeanUtils.copyProperties(payment, sellerPay);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return payment;
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

}
