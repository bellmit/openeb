package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.EvalGoodsT;
import com.gsccs.b2c.plat.shop.model.EvalGoodsTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvalProductMapper {

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