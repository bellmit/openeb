package com.gsccs.b2c.plat.buyer.service;

import java.util.List;

import com.gsccs.eb.api.domain.base.Account;
import com.gsccs.eb.api.domain.buyer.Buyer;
import com.gsccs.eb.api.domain.buyer.Deliver;
import com.gsccs.eb.api.domain.buyer.Grade;
import com.gsccs.eb.api.domain.buyer.Points;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface BuyerService {
	
	public Buyer getBuyer(Long id);

	public List<Buyer> findBuyerList(Buyer param, int page, int rows);

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
	List<Deliver> findDeliverList(Long sid, Long uid);

	Deliver getDeliver(Long userid, Long deliverid);

	public List<Grade> findGradeList();

	public Grade getGrade(Long id);

	public void saveGrade(Grade param);
}
