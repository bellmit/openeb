package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.plat.buyer.model.BuyerDeliver;
import com.gsccs.b2c.plat.buyer.service.BuyerService;
import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.domain.buyer.Points;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 会员服务接口API
 * @author x.d zhang
 */
public class BuyerServiceAPI implements BuyerServiceI {

	@Autowired
	private StoreService storeService;
	@Autowired
	private BuyerService buyerService;

	// 根据店铺ID查询会员信息
	@Override
	public Account getBuyer(Long sid, Long uid) throws ApiException {
		if (null == sid || null == uid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Store store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		com.gsccs.b2c.plat.buyer.model.Account baccount = buyerService.getBuyerAccount(uid, sid);
		if (null != baccount) {
			Account o = new Account();
			o.setUserId(uid);
			o.setNick(baccount.getNick());
			return o;
		}
		return null;
	}

	// 会员注册
	@Override
	public void addAccount(Long sid, Account user) throws ApiException {
		if (null == sid || null == user
				|| StringUtils.isEmpty(user.getAccount())) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		Account buyerAccount = new Account();
		buyerAccount.setAccount(user.getAccount());
		buyerAccount.setNick(user.getAccount());
		/*buyerAccount.setPwd(user.getPassword());
		buyerAccount.setState("1");
		buyerAccount.setAddtime(new Date());
		buyerAccount.setIslock("1");
		buyerService.addBuyer(sid, buyerAccount);*/
	}

	// 根据店铺ID查询所有会员
	@Override
	public List<Account> getBuyerByShopid(Long sid,int page,int rows) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		List<com.gsccs.b2c.plat.buyer.model.Account> accountList = buyerService.getBuyerList(null, page, rows);
		if (null != accountList) {
			List<Account> users = new ArrayList<Account>();
			Account user = null;
			for (com.gsccs.b2c.plat.buyer.model.Account buyerAccount : accountList) {
				user = new Account();
				user.setUserId(buyerAccount.getId());
				user.setAccount(buyerAccount.getAccount());
				user.setNick(buyerAccount.getNick());
				users.add(user);
			}
			return users;
		}
		return null;
	}

	// 根据店铺ID与会员账号查询用户
	@Override
	public Account findByAccount(Long sid, String account) throws ApiException {
		if (null == sid || null == account) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		com.gsccs.b2c.plat.buyer.model.Account baccount = buyerService.getBuyerAccount(sid, account);
		if (null != baccount) {
			com.gsccs.b2c.api.domain.Account o = new com.gsccs.b2c.api.domain.Account();
			o.setUserId(baccount.getId());
			o.setNick(baccount.getNick());
			o.setAccount(baccount.getAccount());
			o.setPassword(baccount.getPwd());
			o.setSalt(baccount.getSalt());
			boolean isLocked = baccount.getIslock() == "1" ? true : false;
			o.setLocked(isLocked);
			return o;
		}
		return null;
	}

	// 会员资料添加并更新
	@Override
	public void updateBuyerInfo(Long sid, Account user) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

	}

	// 会员登录
	@Override
	public Account loginAccount(Long sid, String account, String pwd)
			throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		com.gsccs.b2c.plat.buyer.model.Account ba = buyerService.loginAccount(sid, account, pwd);
		if (null != ba) {
			Account user = new Account();
			user.setAccount(ba.getAccount());
			user.setUserId(ba.getId());
			user.setNick(ba.getNick());
			return user;
		}
		return null;
	}

	@Override
	public List<Grade> getBuyerLevels(Long sid) throws ApiException {
		List<Grade> result = null;
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Store store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		List<Grade> levels = buyerService.findBuyerLevels(sid);
		if (null != levels && levels.size() > 0) {
			result = new ArrayList<Grade>();
			Grade level = null;
			for (Grade l : levels) {
				level = new Grade();
				result.add(level);
				try {
					BeanUtils.copyProperties(level, l);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public JSONArray buyerDelivers(Long sid, Long uid) throws ApiException {
		JSONArray array = new JSONArray();
		List<BuyerDeliver> delivers = buyerService.findDeliverList(sid,
				uid);
		if (null != delivers) {
			array = (JSONArray) JSON.toJSON(delivers);
		}
		return array;
	}

	@Override
	public void addBuyerDelivers(Long sid, Deliver dlv)
			throws ApiException {
		if (null == sid && null == dlv) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Store store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		buyerService.saveDeliver(sid, dlv);
	}

	@Override
	public Deliver getbuyerDeliver(Long sid, Long uid, Long addressid)
			throws ApiException {
		return buyerService.getDeliver(uid, addressid);
	}

	@Override
	public List<Points> getBuyerPoints(Long sid, Points param,
			int page, int pagesize) throws ApiException {
		List<Points> list = buyerService.getBuyerPoints(sid, param, page,
				pagesize);
		return list;
	}

	@Override
	public int getBuyerPoint(Long sid, Long buyerid) throws ApiException {
		return buyerService.getBuyerPoints(sid, buyerid);
	}

	@Override
	public void deletebuyerDeliver(Long sid, Long addressid)
			throws ApiException {

	}

}
