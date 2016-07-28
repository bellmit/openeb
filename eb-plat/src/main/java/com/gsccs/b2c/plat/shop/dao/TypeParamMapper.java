package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.TypeParamExample;
import com.gsccs.eb.api.domain.goods.TypeParam;

public interface TypeParamMapper {
	int countByExample(TypeParamExample example);

	int deleteByExample(TypeParamExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TypeParam record);

	int insertSelective(TypeParam record);

	List<TypeParam> selectByExample(TypeParamExample example);

	TypeParam selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TypeParam record,
			@Param("example") TypeParamExample example);

	int updateByExample(@Param("record") TypeParam record,
			@Param("example") TypeParamExample example);

	int updateByPrimaryKeySelective(TypeParam record);

	int updateByPrimaryKey(TypeParam record);
}