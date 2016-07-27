package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.BrandT;
import com.gsccs.b2c.plat.shop.model.BrandTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface BrandMapper {

	int countByExample(BrandTExample example);

	int deleteByExample(BrandTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(BrandT record);

	int insertSelective(BrandT record);

	List<BrandT> selectByExample(BrandTExample example);
	List<BrandT> selectPageByExample(BrandTExample example);

	BrandT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") BrandT record,
			@Param("example") BrandTExample example);

	int updateByExample(@Param("record") BrandT record,
			@Param("example") BrandTExample example);

	int updateByPrimaryKeySelective(BrandT record);

	int updateByPrimaryKey(BrandT record);
}