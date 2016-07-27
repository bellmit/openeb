package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.Specific;
import com.gsccs.b2c.plat.shop.model.SpecificExample;

public interface SpecificMapper {
	
	int countByExample(SpecificExample example);

	int deleteByExample(SpecificExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Specific record);

	List<Specific> selectByExample(SpecificExample example);
	List<Specific> selectPageByExample(SpecificExample example);

	Specific selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Specific record,
			@Param("example") SpecificExample example);

	int updateByExample(@Param("record") Specific record,
			@Param("example") SpecificExample example);
	
	List<Specific> selectByType(@Param("typeId") Long typeId);
	
	int updateByPrimaryKeySelective(Specific record);

	int updateByPrimaryKey(Specific record);
}