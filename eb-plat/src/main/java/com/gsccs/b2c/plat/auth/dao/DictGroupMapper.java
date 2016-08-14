package com.gsccs.b2c.plat.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.auth.model.DictGroup;
import com.gsccs.b2c.plat.auth.model.DictGroupExample;

public interface DictGroupMapper {
	int countByExample(DictGroupExample example);

	int deleteByExample(DictGroupExample example);

	int deleteByPrimaryKey(String id);

	int insert(DictGroup record);

	List<DictGroup> selectByExample(DictGroupExample example);

	DictGroup selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") DictGroup record,
			@Param("example") DictGroupExample example);

	int updateByExample(@Param("record") DictGroup record,
			@Param("example") DictGroupExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table plat_dict_group
	 * 
	 * @mbggenerated Wed Mar 09 16:36:37 CST 2016
	 */
	int updateByPrimaryKeySelective(DictGroup record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table plat_dict_group
	 * 
	 * @mbggenerated Wed Mar 09 16:36:37 CST 2016
	 */
	int updateByPrimaryKey(DictGroup record);

	DictGroup selectByTitle(String title);

	DictGroup selectByCode(String code);
}