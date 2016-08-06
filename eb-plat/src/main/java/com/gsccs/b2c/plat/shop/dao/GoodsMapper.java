package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.GoodsExample;
import com.gsccs.eb.api.domain.goods.Goods;

/**
 * 
 * @author x.d zhang
 * 
 */
public interface GoodsMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") GoodsExample example);

	int deleteByExample(@Param("sid") Long sid,
			@Param("example") GoodsExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int insert(@Param("record") Goods record);

	List<Goods> selectByExample(@Param("sid") Long sid,
			@Param("example") GoodsExample example);

	List<Goods> selectPageByShop(@Param("sid") Long sid,
			@Param("example") GoodsExample example);

	List<Goods> selectPageByExample(@Param("example") GoodsExample example);

	Goods selectByPrimaryKey(@Param("id") Long id);

	int updateByExampleSelective(@Param("record") Goods record,
			@Param("example") GoodsExample example);

	int updateByExample(@Param("record") Goods record,
			@Param("example") GoodsExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") Goods record);

	void updateGoodsUnsale(@Param("sid") Long sid,
			@Param("storenum") Integer storenum);
}