package com.gsccs.b2c.plat.rated.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.rated.model.EvalConfT;
import com.gsccs.b2c.plat.rated.model.EvalConfTExample;

public interface EvalConfMapper {
	
    int countByExample(EvalConfTExample example);

    int deleteByExample(EvalConfTExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EvalConfT record);

    int insertSelective(EvalConfT record);

    List<EvalConfT> selectByExample(EvalConfTExample example);
    
    EvalConfT selectByPrimaryKey(Long id);
    
    int updateByExample(@Param("record") EvalConfT record, @Param("example") EvalConfTExample example);

    int updateByPrimaryKeySelective(EvalConfT record);

    int updateByPrimaryKey(EvalConfT record);
}