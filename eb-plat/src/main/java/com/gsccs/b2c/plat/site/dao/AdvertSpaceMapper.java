package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.AdvertSpaceExample;
import com.gsccs.eb.api.domain.site.AdvertSpace;

public interface AdvertSpaceMapper {

	int countByExample(AdvertSpaceExample example);

	int deleteByExample(AdvertSpaceExample example);

	int deleteByPrimaryKey(Long id);

	int insert(AdvertSpace record);

	int insertSelective(AdvertSpace record);

	List<AdvertSpace> selectPageByExample(AdvertSpaceExample example);

	AdvertSpace selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") AdvertSpace record,
			@Param("example") AdvertSpaceExample example);

	int updateByExample(@Param("record") AdvertSpace record,
			@Param("example") AdvertSpaceExample example);

	int updateByPrimaryKeySelective(AdvertSpace record);

	int updateByPrimaryKey(AdvertSpace record);
}