package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.ProductT;
import com.gsccs.b2c.plat.shop.model.ProductTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author x.d zhang
 *
 */
public interface ProductTMapper {

	int countByExample(@Param("sid") Long sid,
			@Param("example") ProductTExample example);

	int deleteByExample(@Param("sid") Long sid,
			@Param("example") ProductTExample example);

	int deleteByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int insert(@Param("sid") Long sid, @Param("record") ProductT record);

	List<ProductT> selectByExample(@Param("sid") Long sid,
			@Param("example") ProductTExample example);

	List<ProductT> selectPageByExample(@Param("sid") Long sid,
			@Param("example") ProductTExample example);

	ProductT selectByPrimaryKey(@Param("sid") Long sid, @Param("id") Long id);

	int updateByExampleSelective(@Param("record") ProductT record,
			@Param("example") ProductTExample example);

	
	int updateByExample(@Param("record") ProductT record,
			@Param("example") ProductTExample example);

	int updateByPrimaryKey(@Param("sid") Long sid, @Param("record") ProductT record);
	
	void updateProductUnsale(@Param("sid") Long sid,@Param("storenum") Integer storenum);
}