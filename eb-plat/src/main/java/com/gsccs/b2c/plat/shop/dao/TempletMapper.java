package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.Templet;
import com.gsccs.b2c.plat.shop.model.TempletExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempletMapper {
    int countByExample(TempletExample example);

    int deleteByExample(TempletExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Templet record);

    int insertSelective(Templet record);

    List<Templet> selectByExample(TempletExample example);

    Templet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Templet record, @Param("example") TempletExample example);

    int updateByExample(@Param("record") Templet record, @Param("example") TempletExample example);

    int updateByPrimaryKeySelective(Templet record);

    int updateByPrimaryKey(Templet record);
    
    long selectMaxId();
}