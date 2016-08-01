package com.gsccs.b2c.plat.seller.dao;

import com.gsccs.b2c.plat.seller.model.Store;
import com.gsccs.b2c.plat.seller.model.StoreExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
	int countByExample(StoreExample example);

	int deleteByExample(StoreExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Store record);

	int insertSelective(Store record);

	List<Store> selectByExample(StoreExample example);

	List<Store> selectPageByExample(StoreExample example);

	Store selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Store record,
			@Param("example") StoreExample example);

	int updateByExample(@Param("record") Store record,
			@Param("example") StoreExample example);

	int updateByPrimaryKeySelective(Store record);

	int updateByPrimaryKey(Store record);

	long selectMaxId();
}