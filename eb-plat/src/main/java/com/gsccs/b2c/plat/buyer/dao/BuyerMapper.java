package com.gsccs.b2c.plat.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.buyer.model.BuyerExample;
import com.gsccs.eb.api.domain.buyer.Buyer;

/**
 * @说明 会员基本信息资料数据操作
 * @开发者 ma hong
 * @年月日 2015年4月8日
 * @时分秒 上午10:39:23
 */
public interface BuyerMapper {

	int countByExample(BuyerExample example);

	int deleteByExample(BuyerExample example);

	// 根据ID删除一条记录
	int deleteByPrimaryKey(Long id);

	int insertSelective(Buyer record);

	// 查询所有
	List<Buyer> selectPageByExample(BuyerExample example);

	// 根据ID查询一条记录
	Buyer selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Buyer record,
			@Param("example") BuyerExample example);

	int updateByExample(@Param("record") Buyer record,
			@Param("example") BuyerExample example);

	int updateByPrimaryKeySelective(Buyer record);

	/*
	 * ==========================================================================
	 * ========================================
	 */

	// 根据ID更新一条记录
	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") Buyer record);

	// 插入会员个人信息 会员初次注册时 同时给会员个人信息表分配ID
	int insert(@Param("record") Buyer record);

}