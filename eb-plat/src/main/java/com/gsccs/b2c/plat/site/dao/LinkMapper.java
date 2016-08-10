package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.LinkExample;
import com.gsccs.eb.api.domain.site.Link;

public interface LinkMapper {
	int countByExample(LinkExample example);

	int deleteByExample(LinkExample example);

	int deleteByPrimaryKey(String id);

	int insert(Link record);

	List<Link> selectByExample(LinkExample example);

	List<Link> selectPageByExample(LinkExample example);

	Link selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Link record,
			@Param("example") LinkExample example);

	int updateByExample(@Param("record") Link record,
			@Param("example") LinkExample example);

	int updateByPrimaryKeySelective(Link record);

	int updateByPrimaryKey(Link record);

	List<Link> selectByPageExample(LinkExample example);
}