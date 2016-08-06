package com.gsccs.b2c.plat.seller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.seller.model.GradeExample;
import com.gsccs.eb.api.domain.seller.Grade;

public interface StoreGradeMapper {
	
	int countByExample(GradeExample example);

	int deleteByExample(GradeExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Grade record);

	int insertSelective(Grade record);

	List<Grade> selectByExample(GradeExample example);

	Grade selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Grade record,
			@Param("example") GradeExample example);

	int updateByExample(@Param("record") Grade record,
			@Param("example") GradeExample example);

	int updateByPrimaryKeySelective(Grade record);

	int updateByPrimaryKey(Grade record);
}