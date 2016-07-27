package com.gsccs.b2c.plat.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.buyer.model.BuyerPointsExample;
import com.gsccs.eb.api.domain.buyer.Points;

public interface BuyerPointsMapper {

	int countByExample(@Param("sid") Long sid,@Param("example") BuyerPointsExample example);

	int insert(@Param("sid") Long sid, @Param("record") Points record);

	List<Points> selectPageByExample(@Param("sid") Long sid,@Param("example") BuyerPointsExample example);

	Points selectByPrimaryKey(Long id);

	int updateByPrimaryKey(Points record);
	
	int deleteByExample(BuyerPointsExample example);

	int deleteByPrimaryKey( Long id);
	
	int selectPointsSum(@Param("sid") Long sid,@Param("buyerid") Long buyerid);
}