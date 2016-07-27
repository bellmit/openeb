package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.CategoryT;
import com.gsccs.b2c.plat.shop.model.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
	
	
	int countByExample(CategoryExample example);

	int deleteByExample(CategoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CategoryT record);

	int insertSelective(CategoryT record);

	List<CategoryT> selectByExample(CategoryExample example);

	List<CategoryT> selectPageByExample(CategoryExample example);

	CategoryT selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") CategoryT record,
			@Param("example") CategoryExample example);

	int updateByPrimaryKey(CategoryT record);
	
	Long selectMaxid(Long pid);

}