package com.gsccs.b2c.plat.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.pay.model.PayArgsExample;
import com.gsccs.eb.api.domain.trade.PayArgs;

public interface PayArgsMapper {

	int countByExample(PayArgsExample example);

	int deleteByExample(PayArgsExample example);

	int deleteByPrimaryKey(String id);

	int insert(PayArgs record);

	int insertSelective(PayArgs record);

	List<PayArgs> selectPageByExample(PayArgsExample example);

	PayArgs selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") PayArgs record,
			@Param("example") PayArgsExample example);

	int updateByExample(@Param("record") PayArgs record,
			@Param("example") PayArgsExample example);

	int updateByPrimaryKeySelective(PayArgs record);

	int updateByPrimaryKey(PayArgs record);
}