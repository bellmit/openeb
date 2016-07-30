package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.SpecValExample;
import com.gsccs.eb.api.domain.goods.SpecVal;

public interface SpecValMapper {
	int countByExample(SpecValExample example);

	int deleteByExample(SpecValExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SpecVal record);

	int insertSelective(SpecVal record);

	List<SpecVal> selectByExample(SpecValExample example);
	
	List<SpecVal> selectBySpecid(Long specid);
	
	SpecVal selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SpecVal record,
			@Param("example") SpecValExample example);

	int updateByExample(@Param("record") SpecVal record,
			@Param("example") SpecValExample example);

	int updateByPrimaryKeySelective(SpecVal record);

	int updateByPrimaryKey(SpecVal record);
}