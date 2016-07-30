package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.TypeSpecExample;
import com.gsccs.eb.api.domain.goods.Specific;
import com.gsccs.eb.api.domain.goods.Type;
import com.gsccs.eb.api.domain.goods.TypeSpec;

public interface TypeSpecMapper {
	int countByExample(TypeSpecExample example);

	int deleteByExample(TypeSpecExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TypeSpec record);

	int insertSelective(TypeSpec record);

	List<TypeSpec> selectByExample(TypeSpecExample example);

	TypeSpec selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TypeSpec record,
			@Param("example") TypeSpecExample example);

	int updateByExample(@Param("record") TypeSpec record,
			@Param("example") TypeSpecExample example);

	int updateByPrimaryKeySelective(TypeSpec record);

	int updateByPrimaryKey(TypeSpec record);
}