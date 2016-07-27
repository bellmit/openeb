package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.EvalItemT;
import com.gsccs.b2c.plat.shop.model.EvalItemTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvalItemMapper {

	int countByExample(EvalItemTExample example);

	int deleteByExample(EvalItemTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(EvalItemT record);

	List<EvalItemT> selectByExample(EvalItemTExample example);

	EvalItemT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") EvalItemT record,
			@Param("example") EvalItemTExample example);

	int updateByPrimaryKey(EvalItemT record);
}