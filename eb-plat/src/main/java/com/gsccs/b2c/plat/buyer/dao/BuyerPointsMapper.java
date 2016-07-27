package com.gsccs.b2c.plat.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.buyer.model.BuyerPoints;
import com.gsccs.b2c.plat.buyer.model.BuyerPointsExample;

public interface BuyerPointsMapper {

	int countByExample(@Param("sid") Long sid,@Param("example") BuyerPointsExample example);

	int insert(@Param("sid") Long sid, @Param("record") BuyerPoints record);

	List<BuyerPoints> selectPageByExample(@Param("sid") Long sid,@Param("example") BuyerPointsExample example);

	BuyerPoints selectByPrimaryKey(Long id);

	int updateByPrimaryKey(BuyerPoints record);
	
	int deleteByExample(BuyerPointsExample example);

	int deleteByPrimaryKey( Long id);
	
	int selectPointsSum(@Param("sid") Long sid,@Param("buyerid") Long buyerid);
}