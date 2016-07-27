package com.gsccs.b2c.plat.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.order.model.OrderItemExample;
import com.gsccs.eb.api.domain.trade.OrderItem;

public interface OrderItemMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") OrderItemExample example);

	int deleteByExample(@Param("sid") Long sid,@Param("example") OrderItemExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid,@Param("id") Long id);

	int insert(@Param("sid") Long sid, @Param("record") OrderItem record);

	List<OrderItem> selectByExample(@Param("example") OrderItemExample example);

	OrderItem selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int updateByExample(@Param("record") OrderItem record,
			@Param("example") OrderItemExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") OrderItem record);

	List<OrderItem> selectOrderItems(@Param("sid") Long sid,
			@Param("oid") Long oid);
	
	List<OrderItem> selectProductItems(@Param("sid") Long sid,
			@Param("pid") Long pid);
	int countProductItems(@Param("sid") Long sid,
			@Param("pid") Long pid);
	
	List<OrderItem> selectIsNotEvalItems(@Param("sid") Long sid,
			@Param("uid") Long uid,@Param("example") OrderItemExample example);
}