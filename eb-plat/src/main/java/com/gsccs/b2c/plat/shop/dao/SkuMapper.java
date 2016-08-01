package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.SkuExample;
import com.gsccs.eb.api.domain.goods.Sku;

public interface SkuMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") SkuExample example);

	int deleteByExample(SkuExample example);

	int deleteByPrimaryKey(Long id);

	int insert(@Param("record") Sku record);

	List<Sku> selectPageByExample(@Param("sid") Long sid,
			@Param("example") SkuExample example);

	List<Sku> selectByExample(@Param("example") SkuExample example);

	Sku selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int updateByExampleSelective(@Param("record") Sku record,
			@Param("example") SkuExample example);

	int updateByExample(@Param("record") Sku record,
			@Param("example") SkuExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") Sku record);
}