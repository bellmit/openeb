package com.gsccs.b2c.plat.deliver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.deliver.model.TempletExample;
import com.gsccs.eb.api.domain.deliver.Templet;

public interface DeliverSetMapper {

	int countByExample(TempletExample example);

	int deleteByExample(TempletExample example);

	int deleteByPrimaryKey(String id);

	int insert(Templet record);

	int insertSelective(Templet record);

	List<Templet> selectByExample(TempletExample example);

	List<Templet> selectPageByExample(TempletExample example);

	Templet selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Templet record,
			@Param("example") TempletExample example);

	int updateByExample(@Param("record") Templet record,
			@Param("example") TempletExample example);

	int updateByPrimaryKeySelective(Templet record);

	int updateByPrimaryKey(Templet record);
}