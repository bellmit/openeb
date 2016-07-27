package com.gsccs.b2c.plat.buyer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.buyer.dao.BuyerInfoMapper;
import com.gsccs.b2c.plat.buyer.dao.BuyerLogMapper;
import com.gsccs.b2c.plat.buyer.model.BuyerInfo;
import com.gsccs.b2c.plat.buyer.model.BuyerLog;

/**
 * @说明 会员个人资料查询服务类
 * @开发者 ma hong
 * @年月日 2015年4月1日
 * @时分秒 上午10:05:33
 */
@Service
public class BuyerInfoServiceImpl implements BuyerInfoService {

	@Resource
	private BuyerInfoMapper buyerInfoMapper;
	@Resource
	private BuyerLogMapper buyerLogMapper;

	// 添加会员资料
	@Override
	public void addBuyerInfo(long sid, BuyerInfo buyerAccountInfo) {
		System.out.println("-------添加会员资料--------");
		this.buyerInfoMapper.insert(sid, buyerAccountInfo);
	}

	// 添加并更新会员资料
	@Override
	public void updateBuyerAccountInfo(long sid, BuyerInfo record) {
		this.buyerInfoMapper.updateByPrimaryKey(sid, record);
	}

	// 保存会员登录及退出操作记录
	@Override
	public void notesBuyerAccountLog(long sid,
			BuyerLog buyerAccountLoginLog) {
		this.buyerLogMapper.insert(sid, buyerAccountLoginLog);
	}

}
