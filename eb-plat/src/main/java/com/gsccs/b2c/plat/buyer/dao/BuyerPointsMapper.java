package com.gsccs.b2c.plat.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.buyer.model.BuyerPointsExample;
import com.gsccs.eb.api.domain.buyer.BuyerScore;

public interface BuyerPointsMapper {

	int countByExample(@Param("sid") Long sid,@Param("example") BuyerPointsExample example);

	int insert(@Param("sid") Long sid, @Param("record") BuyerScore record);

	List<BuyerScore> selectPageByExample(@Param("sid") Long sid,@Param("example") BuyerPointsExample example);

	BuyerScore selectByPrimaryKey(Long id);

	int updateByPrimaryKey(BuyerScore record);
	
	int deleteByExample(BuyerPointsExample example);

	int deleteByPrimaryKey( Long id);
	
	int selectPointsSum(@Param("sid") Long sid,@Param("buyerid") Long buyerid);
}