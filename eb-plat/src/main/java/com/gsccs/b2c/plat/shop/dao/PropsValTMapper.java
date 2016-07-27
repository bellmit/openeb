package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.PropsValT;
import com.gsccs.b2c.plat.shop.model.PropsValTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropsValTMapper {
    int countByExample(PropsValTExample example);

    int deleteByExample(PropsValTExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropsValT record);

    int insertSelective(PropsValT record);

    List<PropsValT> selectByExample(PropsValTExample example);

    PropsValT selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropsValT record, @Param("example") PropsValTExample example);

    int updateByExample(@Param("record") PropsValT record, @Param("example") PropsValTExample example);

    int updateByPrimaryKeySelective(PropsValT record);

    int updateByPrimaryKey(PropsValT record);
}