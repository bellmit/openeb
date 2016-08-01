package com.gsccs.b2c.plat.seller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.seller.model.SellerAccount;
import com.gsccs.b2c.plat.seller.model.SellerAccountExample;

/**
 * 
 * @author x.d zhang
 *
 */
public interface SellerAccountMapper {
	
	int countByExample(SellerAccountExample example);

	int deleteByExample(SellerAccountExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SellerAccount record);

	List<SellerAccount> selectByExample(SellerAccountExample example);

	SellerAccount selectByPrimaryKey(Long id);

	int updateByExample(@Param("record") SellerAccount record,
			@Param("example") SellerAccountExample example);

	int updateByPrimaryKey(SellerAccount record);

	SellerAccount selectByAccount(String account);
}