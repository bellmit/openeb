package com.gsccs.b2c.plat.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.order.model.ReturnOrderExample;
import com.gsccs.b2c.plat.order.model.ReturnOrderT;

public interface ReturnOrderMapper {
    int countByExample(@Param("sid") Long sid,@Param("example") ReturnOrderExample example);

    int deleteByExample(ReturnOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(@Param("sid") Long sid, @Param("record") ReturnOrderT record);

    int insertSelective(ReturnOrderT record);

    List<ReturnOrderT> selectByExample(ReturnOrderExample example);
    
    List<ReturnOrderT> selectPageByExample(@Param("sid") Long sid,
			@Param("example") ReturnOrderExample example);

    ReturnOrderT selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

    int updateByExampleSelective(@Param("record") ReturnOrderT record, @Param("example") ReturnOrderExample example);

    int updateByExample(@Param("record") ReturnOrderT record, @Param("example") ReturnOrderExample example);

    int updateByPrimaryKeySelective(ReturnOrderT record);

    int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") ReturnOrderT record);
}