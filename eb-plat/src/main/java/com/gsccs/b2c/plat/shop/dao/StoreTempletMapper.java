package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.StoreTemplet;
import com.gsccs.b2c.plat.shop.model.StoreTempletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreTempletMapper {
    int countByExample(StoreTempletExample example);

    int deleteByExample(StoreTempletExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreTemplet record);

    int insertSelective(StoreTemplet record);

    List<StoreTemplet> selectByExample(StoreTempletExample example);

    StoreTemplet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreTemplet record, @Param("example") StoreTempletExample example);

    int updateByExample(@Param("record") StoreTemplet record, @Param("example") StoreTempletExample example);

    int updateByPrimaryKeySelective(StoreTemplet record);

    int updateByPrimaryKey(StoreTemplet record);
}