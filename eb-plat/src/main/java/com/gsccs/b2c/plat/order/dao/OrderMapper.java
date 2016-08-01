package com.gsccs.b2c.plat.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.order.model.OrderExample;
import com.gsccs.b2c.plat.order.model.OrderStatist;
import com.gsccs.eb.api.domain.trade.Order;

public interface OrderMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") OrderExample example);

	int deleteByExample(@Param("sid") Long sid, OrderExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int deleteByOrdersn(@Param("sid") Long sid, @Param("ordersn") String ordersn);

	int insert(@Param("sid") Long sid, @Param("record") Order record);

	List<Order> selectPageByExample(@Param("example") OrderExample example);

	Order selectByPrimaryKey(@Param("id") Long id);

	Order selectByOrdersn(@Param("sid") Long sid,
			@Param("ordersn") String ordersn);

	int updateByExample(@Param("record") Order record,
			@Param("example") OrderExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") Order record);

	List<OrderStatist> orderStatistGroupState(@Param("sid") Long sid,
			@Param("buyerid") Long buyerid);

}