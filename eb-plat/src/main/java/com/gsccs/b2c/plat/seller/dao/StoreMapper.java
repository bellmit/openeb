package com.gsccs.b2c.plat.seller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.seller.model.ShopExample;
import com.gsccs.eb.api.domain.seller.Shop;

public interface StoreMapper {
	int countByExample(ShopExample example);

	int deleteByExample(ShopExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Shop record);

	int insertSelective(Shop record);

	List<Shop> selectByExample(ShopExample example);

	List<Shop> selectPageByExample(ShopExample example);

	Shop selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Shop record,
			@Param("example") ShopExample example);

	int updateByExample(@Param("record") Shop record,
			@Param("example") ShopExample example);

	int updateByPrimaryKeySelective(Shop record);

	int updateByPrimaryKey(Shop record);

	long selectMaxId();
}