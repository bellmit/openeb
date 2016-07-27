package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.ProductExtra;
import com.gsccs.b2c.plat.shop.model.ProductExtraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductExtraMapper {
	int countByExample(ProductExtraExample example);

	int deleteByExample(ProductExtraExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ProductExtra record);

	int insertSelective(ProductExtra record);

	List<ProductExtra> selectByExample(ProductExtraExample example);

	ProductExtra selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ProductExtra record,
			@Param("example") ProductExtraExample example);

	
	int updateByExample(@Param("record") ProductExtra record,
			@Param("example") ProductExtraExample example);

	int updateByPrimaryKeySelective(ProductExtra record);

	int updateByPrimaryKey(ProductExtra record);
}