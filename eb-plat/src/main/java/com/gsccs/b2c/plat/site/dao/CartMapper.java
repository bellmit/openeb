package com.gsccs.b2c.plat.site.dao;

import com.gsccs.b2c.plat.site.model.Cart;
import com.gsccs.b2c.plat.site.model.CartExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    int countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(@Param("sid") Long sid,  @Param("id") Long id);

    int insert(@Param("sid") Long sid, @Param("record")Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(@Param("sid") Long sid,  @Param("example") CartExample example);
    
    List<Cart> selectCartsByBuyer(@Param("sid") Long sid,  @Param("buyer") String buyer);

    Cart selectByPrimaryKey(@Param("sid") Long sid,  @Param("id") Long id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
    
    int updateCart(@Param("sid") Long sid,  @Param("record")Cart record);

	List<Cart> selectCheckedCart(@Param("sid") long siteId, @Param("cartIds") String cartIds);
}