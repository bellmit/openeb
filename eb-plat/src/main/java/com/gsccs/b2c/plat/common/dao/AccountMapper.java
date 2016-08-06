package com.gsccs.b2c.plat.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.common.model.AccountExample;
import com.gsccs.eb.api.domain.base.Account;

/**
 * @说明   会员登录相关操作数据映射
 * @开发者 ma hong
 * @年月日 2015年4月7日
 * @时分秒 下午3:26:38
 */
public interface AccountMapper {

	int countByExample(AccountExample example);

	int deleteByExample(AccountExample example);

	int deleteByPrimaryKey(Long id);


	int updateByExample(@Param("record") Account record,@Param("example") AccountExample example);

	int insert(Account record);

	int updateByPrimaryKey(Account record);
	/*=================================================================================================================================*/

	// 根据店铺ID查询会员信息
	Account selectByPrimaryKey(@Param("id") Long id);
	
	// 根据店铺ID与会员账号查询
	Account selectByAccount(@Param("account") String account,@Param("sid") Long sid);
	
	// 查询会员 
	List<Account> selectPageByExample(@Param("example") AccountExample example);
	
	// 添加新会员
	void insert(@Param("sid") Long sid,@Param("record")Account record);
	
	// 会员登录
	Account loginAccount(@Param("sid")Long sid,String account,String pwd);
	

}