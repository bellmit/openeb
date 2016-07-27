package com.gsccs.b2c.plat.buyer.service;

import com.gsccs.b2c.plat.buyer.model.BuyerInfo;
import com.gsccs.b2c.plat.buyer.model.BuyerLog;

/**
 * @说明 	 用户个人资料查询服务类
 * @开发者 ma hong
 * @年月日 2015年4月1日
 * @时分秒 上午10:05:33
 */
public interface BuyerInfoService {

	//会员注册时
	public void addBuyerInfo(long sid,BuyerInfo buyerAccountInfo);
	
	//添加并更新会员资料
    public void updateBuyerAccountInfo(long sid,BuyerInfo record);
	 
	
    public void notesBuyerAccountLog(long sid,BuyerLog buyerAccountLoginLog);
	
	
	//查询会员资料
	//public BuyerAccountInfo getBuyerAccountInfo(Long id);
	
	//查询所有用户资料（list）
	//public List<BuyerAccountInfo> getBuyerAccountInfos();
	
	//删除一条会员资料
	//public void deleteBuyerAccountInfo(Long id);
	
}
