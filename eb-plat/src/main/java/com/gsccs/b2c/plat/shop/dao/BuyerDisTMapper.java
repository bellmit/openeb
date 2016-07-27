package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.BuyerDisT;
import com.gsccs.b2c.plat.shop.model.BuyerDisTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyerDisTMapper {
	int countByExample(BuyerDisTExample example);

	int deleteByExample(BuyerDisTExample example);

	int deleteByPrimaryKey(Long id);

	int insert(BuyerDisT record);

	int insertSelective(BuyerDisT record);

	List<BuyerDisT> selectByExample(BuyerDisTExample example);

	BuyerDisT selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") BuyerDisT record,
			@Param("example") BuyerDisTExample example);

	int updateByExample(@Param("record") BuyerDisT record,
			@Param("example") BuyerDisTExample example);

	int updateByPrimaryKeySelective(BuyerDisT record);

	int updateByPrimaryKey(BuyerDisT record);
	
	
}