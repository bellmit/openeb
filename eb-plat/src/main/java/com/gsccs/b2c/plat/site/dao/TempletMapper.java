package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.Templet;
import com.gsccs.b2c.plat.site.model.TempletExample;

public interface TempletMapper {
	int countByExample(TempletExample example);

	int deleteByExample(TempletExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Templet record);

	int insertSelective(Templet record);

	List<Templet> selectByExample(TempletExample example);

	Templet selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Templet record,
			@Param("example") TempletExample example);

	int updateByExample(@Param("record") Templet record,
			@Param("example") TempletExample example);

	int updateByPrimaryKeySelective(Templet record);

	int updateByPrimaryKey(Templet record);

	long selectMaxId();
}