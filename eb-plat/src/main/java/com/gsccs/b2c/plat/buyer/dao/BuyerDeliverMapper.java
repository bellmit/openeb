package com.gsccs.b2c.plat.buyer.dao;

import com.gsccs.b2c.plat.buyer.model.BuyerDeliverExample;
import com.gsccs.b2c.plat.buyer.model.BuyerDeliverT;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @说明 会员中心--收货地址数据操作映射
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 下午5:05:20
 */
public interface BuyerDeliverMapper {

	BuyerDeliverT selectByPrimaryKey(@Param("sid") Long sid,
			@Param("id") Long id);

	int updateByExample(@Param("record") BuyerDeliverT record,
			@Param("example") BuyerDeliverExample example);

	// 保存一条会员收货地址
	int insert(@Param("sid") Long sid, @Param("record") BuyerDeliverT record);

	// 更新会员收货地址
	int updateByPrimaryKey(@Param("sid") Long sid,
			@Param("record") BuyerDeliverT record);

	// 删除一条会员收货地址
	int deleteByPrimaryKey(@Param("sid") Long sid, @Param("aid") Long aid);

	// 查询会员多个收货地址
	List<BuyerDeliverT> findByUid(@Param("sid") Long sid, @Param("uid") Long uid);

}