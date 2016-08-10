package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.ChannelExample;
import com.gsccs.eb.api.domain.site.Channel;

public interface ChannelMapper {

	int countByExample(ChannelExample example);

	int deleteByExample(ChannelExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Channel record);

	int insertSelective(Channel record);

	List<Channel> selectByExample(ChannelExample example);

	Channel selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Channel record,
			@Param("example") ChannelExample example);

	int updateByExample(@Param("record") Channel record,
			@Param("example") ChannelExample example);

	int updateByPrimaryKeySelective(Channel record);
	
	int updateByPrimaryKeyWithBLOBs(Channel record);
}