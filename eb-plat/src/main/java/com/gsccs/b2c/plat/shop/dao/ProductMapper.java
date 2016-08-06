package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.ProductExample;
import com.gsccs.eb.api.domain.goods.Product;

/**
 * 
 * @author x.d zhang
 *
 */
public interface ProductMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") ProductExample example);

	int deleteByExample(@Param("sid") Long sid,
			@Param("example") ProductExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int insert(@Param("record") Product record);

	List<Product> selectByExample(@Param("sid") Long sid,
			@Param("example") ProductExample example);

	List<Product> selectPageByShop(@Param("sid") Long sid,
			@Param("example") ProductExample example);
	
	List<Product> selectPageByExample(
			@Param("example") ProductExample example);
	
	Product selectByPrimaryKey(@Param("id") Long id);

	int updateByExampleSelective(@Param("record") Product record,
			@Param("example") ProductExample example);

	
	int updateByExample(@Param("record") Product record,
			@Param("example") ProductExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") Product record);
	
	void updateProductUnsale(@Param("sid") Long sid,@Param("storenum") Integer storenum);
}