package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.CartItemExample;
import com.gsccs.eb.api.domain.trade.CartItem;

public interface CartItemMapper {
	
	int countByExample(CartItemExample example);

	int deleteByExample(CartItemExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int insert(@Param("sid") Long sid, @Param("record") CartItem record);

	int insertSelective(CartItem record);

	List<CartItem> selectByExample(@Param("sid") Long sid,
			@Param("example") CartItemExample example);

	List<CartItem> selectCartsByBuyer(@Param("sid") Long sid,
			@Param("buyerid") Long buyer);

	CartItem selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int updateByExampleSelective(@Param("record") CartItem record,
			@Param("example") CartItemExample example);

	int updateByExample(@Param("record") CartItem record,
			@Param("example") CartItemExample example);

	int updateByPrimaryKeySelective(CartItem record);

	int updateByPrimaryKey(CartItem record);

	int updateCart(@Param("sid") Long sid, @Param("record") CartItem record);

	List<CartItem> selectCheckedCart(@Param("sid") Long siteId,
			@Param("cartIds") String cartIds);
}