package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.CategoryExample;
import com.gsccs.eb.api.domain.goods.Category;

public interface CategoryMapper {

	int countByExample(CategoryExample example);

	int deleteByExample(CategoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Category record);

	int insertSelective(Category record);

	List<Category> selectByExample(CategoryExample example);

	List<Category> selectPageByExample(CategoryExample example);

	Category selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") Category record,
			@Param("example") CategoryExample example);

	int updateByPrimaryKey(Category record);

	Long selectMaxid(Long pid);

}