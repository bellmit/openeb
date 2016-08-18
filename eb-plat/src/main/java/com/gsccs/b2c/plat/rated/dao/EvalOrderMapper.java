package com.gsccs.b2c.plat.rated.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.rated.model.EvalOrderT;
import com.gsccs.b2c.plat.rated.model.EvalOrderTExample;

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