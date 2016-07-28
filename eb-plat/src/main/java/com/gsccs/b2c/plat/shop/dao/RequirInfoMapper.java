package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.RequirInfoExample;
import com.gsccs.eb.api.domain.goods.RequirInfo;

public interface RequirInfoMapper {
	int countByExample(RequirInfoExample example);

	int deleteByExample(RequirInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RequirInfo record);

	int insertSelective(RequirInfo record);

	List<RequirInfo> selectByExample(RequirInfoExample example);

	RequirInfo selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RequirInfo record,
			@Param("example") RequirInfoExample example);

	int updateByExample(@Param("record") RequirInfo record,
			@Param("example") RequirInfoExample example);

	int updateByPrimaryKeySelective(RequirInfo record);

	int updateByPrimaryKey(RequirInfo record);
}