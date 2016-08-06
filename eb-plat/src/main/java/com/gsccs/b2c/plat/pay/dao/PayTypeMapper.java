package com.gsccs.b2c.plat.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.pay.model.PayTypeExample;
import com.gsccs.eb.api.domain.trade.PayType;

public interface PayTypeMapper {

	int countByExample(PayTypeExample example);

	int deleteByExample(PayTypeExample example);

	int deleteByPrimaryKey(String id);

	int insert(PayType record);

	int insertSelective(PayType record);

	List<PayType> selectByExample(PayTypeExample example);

	PayType selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") PayType record,
			@Param("example") PayTypeExample example);

	int updateByExample(@Param("record") PayType record,
			@Param("example") PayTypeExample example);

	int updateByPrimaryKeySelective(PayType record);

	int updateByPrimaryKey(PayType record);
}