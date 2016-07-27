package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.model.GoodsTExample;
import com.gsccs.b2c.plat.shop.model.ProductT;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsTMapper {
	
	int countByExample(@Param("sid") Long sid,
			@Param("example") GoodsTExample example);

	int deleteByExample(GoodsTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(@Param("sid") Long sid, @Param("record") GoodsT record);

	List<GoodsT> selectPageByExample(@Param("sid") Long sid,
			@Param("example") GoodsTExample example);

	List<GoodsT> selectByExample(@Param("sid") Long sid,
			@Param("example") GoodsTExample example);
	
	GoodsT selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int updateByExampleSelective(@Param("record") GoodsT record,
			@Param("example") GoodsTExample example);

	int updateByExample(@Param("record") GoodsT record,
			@Param("example") GoodsTExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") GoodsT record);
}