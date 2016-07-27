package com.gsccs.b2c.plat.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.order.model.OrderExample;
import com.gsccs.b2c.plat.order.model.OrderStatist;
import com.gsccs.b2c.plat.order.model.OrderT;



public interface OrderMapper {
	
    int countByExample(@Param("sid") Long sid,@Param("example") OrderExample example);
    int deleteByExample(@Param("sid") Long sid,OrderExample example);
    int deleteByPrimaryKey(@Param("sid") Long sid,@Param("id")Long id);
    int deleteByOrdersn(@Param("sid") Long sid,@Param("ordersn") String ordersn);
    
    int insert(@Param("sid") Long sid, @Param("record") OrderT record);
    
    List<OrderT> selectPageByExample(@Param("sid") Long sid,
			@Param("example") OrderExample example);
    
    OrderT selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);
    OrderT selectByOrdersn(@Param("sid") Long sid, @Param("ordersn") String ordersn);
    int updateByExample(@Param("record") OrderT record, @Param("example") OrderExample example);
    int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") OrderT record);
    List<OrderStatist> orderStatistGroupState(@Param("sid") Long sid,@Param("buyerid") Long buyerid);
    
}