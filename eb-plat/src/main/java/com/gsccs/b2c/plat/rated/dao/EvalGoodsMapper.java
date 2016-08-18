package com.gsccs.b2c.plat.rated.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.rated.model.EvalGoodsT;
import com.gsccs.b2c.plat.rated.model.EvalGoodsTExample;

public interface EvalGoodsMapper {

	int countByExample(EvalGoodsTExample example);

	int deleteByExample(EvalGoodsTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(@Param("sid") Long siteid, @Param("record") EvalGoodsT record);

	List<EvalGoodsT> selectByExample(EvalGoodsTExample example);

	EvalGoodsT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") EvalGoodsT record,
			@Param("example") EvalGoodsTExample example);

	int updateByPrimaryKey(EvalGoodsT record);
}