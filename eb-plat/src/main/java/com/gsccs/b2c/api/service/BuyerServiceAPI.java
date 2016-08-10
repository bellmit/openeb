package com.gsccs.b2c.api.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.APIConst;
import com.gsccs.b2c.plat.buyer.service.BuyerService;
import com.gsccs.b2c.plat.common.service.AccountService;
import com.gsccs.b2c.plat.seller.service.ShopService;
import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.domain.buyer.Buyer;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.domain.buyer.Points;
import com.gsccs.eb.api.domain.seller.Shop;
import com.gsccs.eb.api.exception.ApiException;

/**
 * 会员服务接口API
 * @author x.d zhang
 */
public class BuyerServiceAPI implements BuyerServiceI {

	@Autowired
	private ShopService storeService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private AccountService accountService;

	// 根据店铺ID查询会员信息
	@Override
	public Account getBuyer(Long sid, Long uid) throws ApiException {
		if (null == sid || null == uid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Account account = accountService.getAccount(uid, sid);
		return account;
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
	public List<Buyer> getBuyerByShopid(Long sid,int page,int rows) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Buyer param = new Buyer();
		param.setShopid(sid);
		List<Buyer> buyerList = buyerService.findBuyerList(param, page, rows);
		return buyerList;
	}

	// 根据店铺ID与会员账号查询用户
	@Override
	public Account findByAccount(Long sid, String account) throws ApiException {
		if (null == sid || null == account) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		return accountService.getAccount(sid, account);
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
		return accountService.loginAccount(sid, account, pwd);
	}

	@Override
	public List<Grade> getBuyerLevels(Long sid) throws ApiException {
		if (null == sid) {
			throw new ApiException(APIConst.ERROR_CODE_0001,
					APIConst.ERROR_MSG_0001);
		}
		Shop store = storeService.findById(sid);
		if (null == store) {
			throw new ApiException(APIConst.ERROR_CODE_0002,
					APIConst.ERROR_MSG_0002);
		}
		return buyerService.findGradeList();
	}

	@Override
	public JSONArray buyerDelivers(Long sid, Long uid) throws ApiException {
		JSONArray array = new JSONArray();
		List<Deliver> delivers = buyerService.findDeliverList(sid,
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
		Shop store = storeService.findById(sid);
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
