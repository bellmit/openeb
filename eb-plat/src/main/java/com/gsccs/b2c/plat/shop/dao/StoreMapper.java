package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.StoreT;
import com.gsccs.b2c.plat.shop.model.StoreTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreMapper {
	int countByExample(StoreTExample example);

	int deleteByExample(StoreTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreT record);

	int insertSelective(StoreT record);

	List<StoreT> selectByExample(StoreTExample example);

	List<StoreT> selectPageByExample(StoreTExample example);

	StoreT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreT record,
			@Param("example") StoreTExample example);

	int updateByExample(@Param("record") StoreT record,
			@Param("example") StoreTExample example);

	int updateByPrimaryKeySelective(StoreT record);

	int updateByPrimaryKey(StoreT record);

	long selectMaxId();
}