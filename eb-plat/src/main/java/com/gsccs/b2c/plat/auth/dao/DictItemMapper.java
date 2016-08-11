package com.gsccs.b2c.plat.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.auth.model.DictItemExample;
import com.gsccs.b2c.plat.auth.model.DictItem;

public interface DictItemMapper {
	
	int countByExample(DictItemExample example);

	int deleteByExample(DictItemExample example);

	int deleteByPrimaryKey(String id);

	int insert(DictItem record);

	List<DictItem> selectByExample(DictItemExample example);

	DictItem selectByPrimaryKey(String id);

	int updateByExample(@Param("record") DictItem record,
			@Param("example") DictItemExample example);

	int updateByPrimaryKey(DictItem record);

	List<DictItem> selectGroupAndItemList(DictItemExample example);
}