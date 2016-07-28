package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.PropertyExample;
import com.gsccs.eb.api.domain.goods.Property;

/**
 * 
 * @author x.d zhang
 *
 */
public interface PropertyMapper {

	int countByExample(PropertyExample example);

	int deleteByExample(PropertyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Property record);

	int insertSelective(Property record);

	List<Property> selectByExample(PropertyExample example);

	Property selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Property record,
			@Param("example") PropertyExample example);

	int updateByExample(@Param("record") Property record,
			@Param("example") PropertyExample example);

	int updateByPrimaryKeySelective(Property record);

	int updateByPrimaryKey(Property record);
}