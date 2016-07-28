package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.BrandExample;
import com.gsccs.eb.api.domain.goods.Brand;


public interface BrandMapper {

	int countByExample(BrandExample example);

	int deleteByExample(BrandExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Brand record);

	int insertSelective(Brand record);

	List<Brand> selectByExample(BrandExample example);
	List<Brand> selectPageByExample(BrandExample example);

	Brand selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Brand record,
			@Param("example") BrandExample example);

	int updateByExample(@Param("record") Brand record,
			@Param("example") BrandExample example);

	int updateByPrimaryKeySelective(Brand record);

	int updateByPrimaryKey(Brand record);
}