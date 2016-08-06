package com.gsccs.b2c.plat.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.common.model.AreaExample;
import com.gsccs.eb.api.domain.base.Area;

/**
 * @说明 省份&城市&区&街道 数据操作
 * @开发者 ma hong
 * @年月日 2015年4月16日
 * @时分秒 上午11:39:48
 */
public interface AreaMapper {

	int countByExample(AreaExample example);

	int deleteByExample(AreaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Area record);

	int insertSelective(Area record);

	List<Area> selectByExample(AreaExample example);

	List<Area> selectPageByExample(AreaExample example);

	Area selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Area record,
			@Param("example") AreaExample example);

	int updateByExample(@Param("record") Area record,
			@Param("example") AreaExample example);

	int updateByPrimaryKeySelective(Area record);

	int updateByPrimaryKey(Area record);

	List<Area> selectByParId(Integer parentid);

}