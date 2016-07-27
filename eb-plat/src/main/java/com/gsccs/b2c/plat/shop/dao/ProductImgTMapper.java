package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.GoodsT;
import com.gsccs.b2c.plat.shop.model.ProductImgT;
import com.gsccs.b2c.plat.shop.model.ProductImgTExample;
import com.gsccs.b2c.plat.shop.model.ProductTExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductImgTMapper {
    int countByExample(ProductImgTExample example);

    int deleteByExample(ProductImgTExample example);

    int deleteByPrimaryKey(Long id);

    int insert(@Param("sid") Long sid, @Param("record") ProductImgT record);

    int insertSelective(ProductImgT record);

    List<ProductImgT> selectByExample(ProductImgTExample example);
    
    List<ProductImgT> selectByPid(@Param("sid") Long sid,
			@Param("productId") Long productId  );

    ProductImgT selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductImgT record, @Param("example") ProductImgTExample example);

    int updateByExample(@Param("record") ProductImgT record, @Param("example") ProductImgTExample example);

    int updateByPrimaryKeySelective(ProductImgT record);

    int updateByPrimaryKey(ProductImgT record);
}