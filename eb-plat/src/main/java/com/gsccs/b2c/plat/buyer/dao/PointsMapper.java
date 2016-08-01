package com.gsccs.b2c.plat.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.buyer.model.PointsExample;
import com.gsccs.eb.api.domain.buyer.Points;

public interface PointsMapper {

	int countByExample(@Param("sid") Long sid,@Param("example") PointsExample example);

	int insert(@Param("sid") Long sid, @Param("record") Points record);

	List<Points> selectPageByExample(@Param("sid") Long sid,@Param("example") PointsExample example);

	Points selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Points record);
	
	int deleteByExample(PointsExample example);

	int deleteByPrimaryKey( Long id);
	
	int selectPointsSum(@Param("sid") Long sid,@Param("buyerid") Long buyerid);
}