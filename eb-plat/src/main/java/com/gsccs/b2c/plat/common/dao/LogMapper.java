package com.gsccs.b2c.plat.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.common.model.LogExample;
import com.gsccs.eb.api.domain.base.Logger;

/**
 * @说明 会员登录及退出操作记录映射
 * @开发者 ma hong
 * @年月日 2015年4月10日
 * @时分秒 下午4:33:16
 */
public interface LogMapper {

	int countByExample(LogExample example);

	int deleteByExample(LogExample example);

	int deleteByPrimaryKey(Long id);

	int insertSelective(Logger record);

	List<Logger> selectByExample(LogExample example);

	Logger selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Logger record,
			@Param("example") LogExample example);

	int updateByExample(@Param("record") Logger record,
			@Param("example") LogExample example);

	int updateByPrimaryKeySelective(Logger record);

	int updateByPrimaryKey(Logger record);

	// 记录会员登录时日志
	int insert(@Param("sid") Long sid, @Param("record") Logger record);

}