package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.EvalOrderT;
import com.gsccs.b2c.plat.shop.model.EvalOrderTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvalOrderMapper {

	int countByExample(EvalOrderTExample example);

	int deleteByExample(EvalOrderTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(@Param("sid") Long siteid, @Param("record") EvalOrderT record);

	List<EvalOrderT> selectByExample(EvalOrderTExample example);

	EvalOrderT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") EvalOrderT record,
			@Param("example") EvalOrderTExample example);

	int updateByPrimaryKey(EvalOrderT record);
}