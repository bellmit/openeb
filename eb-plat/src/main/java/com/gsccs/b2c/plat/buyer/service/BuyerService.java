package com.gsccs.b2c.plat.buyer.service;

import java.util.List;

import com.gsccs.b2c.plat.buyer.model.Account;
import com.gsccs.b2c.plat.buyer.model.BuyerDeliver;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.domain.buyer.Points;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface BuyerService {

	public Long addBuyer(Long sid, Account account);

	public Account loginAccount(Long sid, String account, String pwd);

	public Account getBuyerAccount(Long uid, Long sid);

	public List<Account> getBuyerList(Account param, int page, int rows);

	public Account getBuyerAccount(Long sid, String account);

	public List<Grade> findBuyerLevels(Long sid);

	// 添加会员积分
	public void insert(Long sid, Points record);

	// 查询会员积分列表
	public List<Points> getBuyerPoints(Long sid, Points record, int page,
			int rows);

	public int getBuyerPoints(Long sid, Long userid);

	// 保存一条会员收货地址
	public void saveDeliver(Long sid, Deliver deliver);

	// 删除一条收货地址
	public void deleteDeliver(Long sid, Long deliverid);

	// 更新收货地址
	public void updateDeliver(Long sid, Deliver deliver);

	// 查询会员多个收货地址
	List<BuyerDeliver> findDeliverList(Long sid, Long uid);

	BuyerDeliver getDeliver(Long userid, Long deliverid);

}
