package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.SkuSpecExample;
import com.gsccs.eb.api.domain.goods.SkuSpec;

public interface SkuSpecMapper {
	int countByExample(SkuSpecExample example);

	int deleteByExample(SkuSpecExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SkuSpec record);

	int insertSelective(SkuSpec record);

	List<SkuSpec> selectByExample(SkuSpecExample example);

	SkuSpec selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SkuSpec record,
			@Param("example") SkuSpecExample example);

	
	int updateByExample(@Param("record") SkuSpec record,
			@Param("example") SkuSpecExample example);

	int updateByPrimaryKeySelective(SkuSpec record);

	int updateByPrimaryKey(SkuSpec record);
}