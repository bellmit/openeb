package com.gsccs.b2c.plat.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.buyer.model.BuyerAccount;
import com.gsccs.b2c.plat.buyer.model.BuyerAccountExample;

/**
 * @说明   会员登录相关操作数据映射
 * @开发者 ma hong
 * @年月日 2015年4月7日
 * @时分秒 下午3:26:38
 */
public interface BuyerAccountMapper {

	int countByExample(BuyerAccountExample example);

	int deleteByExample(BuyerAccountExample example);

	int deleteByPrimaryKey(Long id);


	int updateByExample(@Param("record") BuyerAccount record,@Param("example") BuyerAccountExample example);

	int insert(BuyerAccount record);

	int updateByPrimaryKey(BuyerAccount record);
	/*=================================================================================================================================*/

	// 根据店铺ID查询会员信息
	BuyerAccount selectByPrimaryKey(@Param("id") Long id, @Param("sid") Long sid);
	
	// 根据店铺ID与会员账号查询
	BuyerAccount selectByAccount(@Param("account") String account,@Param("sid") Long sid);
	
	// 根据店铺ID查询所有会员 
	List<BuyerAccount> selectAllAcountBySid(@Param("sid") Long sid);
	
	// 添加新会员
	void insert(@Param("sid") Long sid,@Param("record")BuyerAccount record);
	
	// 会员登录
	BuyerAccount loginAccount(@Param("sid")Long sid,String account,String pwd);
	

}