package com.gsccs.b2c.plat.order.dao;

import com.gsccs.b2c.plat.order.model.OrderItemT;
import com.gsccs.b2c.plat.order.model.OrderItemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderItemMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") OrderItemExample example);

	int deleteByExample(@Param("sid") Long sid,@Param("example") OrderItemExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid,@Param("id") Long id);

	int insert(@Param("sid") Long sid, @Param("record") OrderItemT record);

	List<OrderItemT> selectByExample(@Param("example") OrderItemExample example);

	OrderItemT selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int updateByExample(@Param("record") OrderItemT record,
			@Param("example") OrderItemExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") OrderItemT record);

	List<OrderItemT> selectOrderItems(@Param("sid") Long sid,
			@Param("oid") Long oid);
	
	List<OrderItemT> selectProductItems(@Param("sid") Long sid,
			@Param("pid") Long pid);
	int countProductItems(@Param("sid") Long sid,
			@Param("pid") Long pid);
	
	List<OrderItemT> selectIsNotEvalItems(@Param("sid") Long sid,
			@Param("uid") Long uid,@Param("example") OrderItemExample example);
}