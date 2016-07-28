package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.PropsValExample;
import com.gsccs.eb.api.domain.goods.PropsVal;

public interface PropsValMapper {
	int countByExample(PropsValExample example);

	int deleteByExample(PropsValExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PropsVal record);

	int insertSelective(PropsVal record);

	List<PropsVal> selectByExample(PropsValExample example);

	PropsVal selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PropsVal record,
			@Param("example") PropsValExample example);

	int updateByExample(@Param("record") PropsVal record,
			@Param("example") PropsValExample example);

	int updateByPrimaryKeySelective(PropsVal record);

	int updateByPrimaryKey(PropsVal record);
}