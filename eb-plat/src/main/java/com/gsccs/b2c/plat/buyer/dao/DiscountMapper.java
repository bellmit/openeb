package com.gsccs.b2c.plat.buyer.dao;

import com.gsccs.b2c.plat.buyer.model.Discount;
import com.gsccs.b2c.plat.buyer.model.DiscountExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DiscountMapper {
	int countByExample(DiscountExample example);

	int deleteByExample(DiscountExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Discount record);

	int insertSelective(Discount record);

	List<Discount> selectByExample(DiscountExample example);

	Discount selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Discount record,
			@Param("example") DiscountExample example);

	int updateByExample(@Param("record") Discount record,
			@Param("example") DiscountExample example);

	int updateByPrimaryKeySelective(Discount record);

	int updateByPrimaryKey(Discount record);
	
	
}