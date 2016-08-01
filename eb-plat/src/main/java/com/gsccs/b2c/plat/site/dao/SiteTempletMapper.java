package com.gsccs.b2c.plat.site.dao;

import com.gsccs.b2c.plat.site.model.SiteTemplet;
import com.gsccs.b2c.plat.site.model.SiteTempletExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SiteTempletMapper {
    int countByExample(SiteTempletExample example);

    int deleteByExample(SiteTempletExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SiteTemplet record);

    int insertSelective(SiteTemplet record);

    List<SiteTemplet> selectByExample(SiteTempletExample example);

    SiteTemplet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SiteTemplet record, @Param("example") SiteTempletExample example);

    int updateByExample(@Param("record") SiteTemplet record, @Param("example") SiteTempletExample example);

    int updateByPrimaryKeySelective(SiteTemplet record);

    int updateByPrimaryKey(SiteTemplet record);
}