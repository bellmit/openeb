package com.gsccs.b2c.plat.buyer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.buyer.dao.BuyerDeliverMapper;
import com.gsccs.b2c.plat.buyer.model.BuyerDeliverT;

/**
 * @说明 会员中心--收货地址数据操作映射
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 下午5:17:37
 */
@Service
public class BuyerAddrServiceImpl implements BuyerAddrService {

	@Resource
	private BuyerDeliverMapper buyerDeliverMapper;

	// 会员中心---保存收货地址保存服务类
	@Override
	public void saveDeliverAddress(Long sid, BuyerDeliverT deliverAddress) {
		if (null != deliverAddress) {
			if (null == deliverAddress.getId()) {
				buyerDeliverMapper.insert(sid, deliverAddress);
			} else {
				buyerDeliverMapper.updateByPrimaryKey(sid, deliverAddress);
			}
		}
	}

	// 会员中心---删除一条收货地址
	@Override
	public void deleteDeliverAddress(Long sid, Long addressid) {
		buyerDeliverMapper.deleteByPrimaryKey(sid, addressid);
	}

	// 会员中心---更新收货地址
	@Override
	public void updateDeliverAddress(Long sid, BuyerDeliverT deliverAddress) {
		this.buyerDeliverMapper.updateByPrimaryKey(sid, deliverAddress);
	}

	// 会员中心---查询会员多个收货地址
	@Override
	public List<BuyerDeliverT> deliverAddressList(Long sid, Long uid) {
		return this.buyerDeliverMapper.findByUid(sid, uid);
	}

	@Override
	public BuyerDeliverT getDeliver(Long sid, Long uid, Long addressid) {
		return buyerDeliverMapper.selectByPrimaryKey(sid, addressid);
	}

}
