package com.gsccs.b2c.plat.site.dao;

import com.gsccs.b2c.plat.site.model.Storey;
import com.gsccs.b2c.plat.site.model.StoreyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreyMapper {
    int countByExample(StoreyExample example);

    int deleteByExample(StoreyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(@Param("sid") Long sid, @Param("record")Storey record);

    int insertSelective(Storey record);

    List<Storey> selectByExample(StoreyExample example);

    Storey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Storey record, @Param("example") StoreyExample example);

    int updateByExample(@Param("record") Storey record, @Param("example") StoreyExample example);

    int updateByPrimaryKeySelective(Storey record);

    int updateByPrimaryKey(Storey record);
}