package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.TypeExample;
import com.gsccs.eb.api.domain.goods.Type;

public interface TypeMapper {

	int countByExample(TypeExample example);

	int deleteByExample(TypeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Type record);

	int insertSelective(Type record);

	List<Type> selectByExample(TypeExample example);

	List<Type> selectPageByExample(TypeExample example);

	Type selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Type record,
			@Param("example") TypeExample example);

	int updateByExample(@Param("record") Type record,
			@Param("example") TypeExample example);

	int updateByPrimaryKeySelective(Type record);

	int updateByPrimaryKey(Type record);
}