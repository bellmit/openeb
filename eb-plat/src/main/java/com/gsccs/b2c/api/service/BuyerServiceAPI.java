package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.api.domain.BuyerDeliver;
import com.gsccs.b2c.api.domain.BuyerLevel;
import com.gsccs.b2c.api.domain.BuyerScore;
import com.gsccs.b2c.api.domain.User;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.plat.buyer.model.BuyerAccount;
import com.gsccs.b2c.plat.buyer.model.BuyerDeliverT;
import com.gsccs.b2c.plat.buyer.model.BuyerPoints;
import com.gsccs.b2c.plat.buyer.service.BuyerAddrService;
import com.gsccs.b2c.plat.buyer.service.BuyerService;
import com.gsccs.b2c.plat.seller.service.StoreService;
import com.gsccs.b2c.plat.shop.model.BuyerLevelT;
import com.gsccs.b2c.plat.shop.model.StoreT;
import com.gsccs.b2c.plat.utils.BeanUtilsEx;

/**
 * 会员服务接口API
 * @author x.d zhang
 */
public class BuyerServiceAPI implements BuyerServiceI {

	@Autowired
	private StoreService storeService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private BuyerAddrService buyerAddrService;

	// 根据店铺ID查询会员信息
	@Override
	public User getBuyer(Long sid, Long uid) throws ApiException {
		if (null == sid || null == uid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		BuyerAccount baccount = buyerService.getBuyerAccount(uid, sid);
		if (null != baccount) {
			User o = new User();
			o.setUserId(uid);
			o.setNick(baccount.getNick());
			return o;
		}
		return null;
	}

	// 会员注册
	@Override
	public void addAccount(Long sid, User user) throws ApiException {
		if (null == sid || null == user
				|| StringUtils.isEmpty(user.getAccount())) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		BuyerAccount buyerAccount = new BuyerAccount();
		buyerAccount.setAccount(user.getAccount());
		buyerAccount.setNick(user.getAccount());
		buyerAccount.setPwd(user.getPassword());
		buyerAccount.setState("1");
		buyerAccount.setAddtime(new Date());
		buyerAccount.setIslock("1");
		buyerService.addBuyer(sid, buyerAccount);
	}

	// 根据店铺ID查询所有会员
	@Override
	public List<User> getAllAcountBySid(Long sid) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		List<BuyerAccount> buyerAccounts = buyerService.getAllAcountBySid(sid);
		if (null != buyerAccounts) {
			List<User> users = new ArrayList<User>();
			User user = null;
			for (BuyerAccount buyerAccount : buyerAccounts) {
				user = new User();
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
	public User findByAccount(Long sid, String account) throws ApiException {
		if (null == sid || null == account) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

		BuyerAccount baccount = buyerService.getBuyerAccount(sid, account);
		if (null != baccount) {
			com.gsccs.b2c.api.domain.User o = new com.gsccs.b2c.api.domain.User();
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
	public void updateBuyerInfo(Long sid, User user) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}

	}

	// 会员登录
	@Override
	public User loginAccount(Long sid, String account, String pwd)
			throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		BuyerAccount ba = buyerService.loginAccount(sid, account, pwd);
		if (null != ba) {
			User user = new User();
			user.setAccount(ba.getAccount());
			user.setUserId(ba.getId());
			user.setNick(ba.getNick());
			return user;
		}
		return null;
	}

	@Override
	public List<BuyerLevel> getBuyerLevels(Long sid) throws ApiException {
		List<BuyerLevel> result = null;
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		List<BuyerLevelT> levels = buyerService.findBuyerLevels(sid);
		if (null != levels && levels.size() > 0) {
			result = new ArrayList<BuyerLevel>();
			BuyerLevel level = null;
			for (BuyerLevelT l : levels) {
				level = new BuyerLevel();
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
		List<BuyerDeliverT> delivers = buyerAddrService.deliverAddressList(sid,
				uid);
		if (null != delivers) {
			array = (JSONArray) JSON.toJSON(delivers);
		}
		return array;
	}

	@Override
	public void addBuyerDelivers(Long sid, BuyerDeliver dlv)
			throws ApiException {
		if (null == sid && null == dlv) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		StoreT store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		BuyerDeliverT buyerDeliverT = new BuyerDeliverT();
		BeanUtilsEx.copyProperties(buyerDeliverT, dlv);
		buyerAddrService.saveDeliverAddress(sid, buyerDeliverT);
	}

	@Override
	public BuyerDeliver getbuyerDeliver(Long sid, Long uid, Long addressid)
			throws ApiException {
		return buyerAddrService.getDeliver(sid, uid, addressid);
	}

	@Override
	public List<BuyerScore> getBuyerPoints(Long sid, BuyerScore point,
			int page, int pagesize) throws ApiException {
		List<BuyerScore> result = null;
		BuyerPoints param = null;
		if (null != point) {
			param = new BuyerPoints();
			BeanUtilsEx.copyProperties(param, point);
		}
		List<BuyerPoints> list = buyerService.getBuyerScores(sid, param, page,
				pagesize);
		if (null != list && list.size() > 0) {
			result = new ArrayList<BuyerScore>();
			BuyerScore o = null;
			for (BuyerPoints t : list) {
				o = new BuyerScore();
				BeanUtilsEx.copyProperties(o, t);
				result.add(o);
			}
		}
		return result;
	}

	@Override
	public int getBuyerPoint(Long sid, Long buyerid) throws ApiException {
		return buyerService.getBuyerScore(sid, buyerid);
	}

	@Override
	public void deletebuyerDeliver(Long sid, Long addressid)
			throws ApiException {

	}

}
