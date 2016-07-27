package com.gsccs.b2c.plat.buyer.dao;

import com.gsccs.b2c.plat.buyer.model.BuyerLog;
import com.gsccs.b2c.plat.buyer.model.BuyerLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @说明  会员登录及退出操作记录映射
 * @开发者 ma hong
 * @年月日 2015年4月10日
 * @时分秒 下午4:33:16
 */
public interface BuyerLogMapper {
	
    int countByExample(BuyerLogExample example);

    int deleteByExample(BuyerLogExample example);

    int deleteByPrimaryKey(Long id);

    int insertSelective(BuyerLog record);

    List<BuyerLog> selectByExample(BuyerLogExample example);

    BuyerLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BuyerLog record, @Param("example") BuyerLogExample example);

    int updateByExample(@Param("record") BuyerLog record, @Param("example") BuyerLogExample example);

    int updateByPrimaryKeySelective(BuyerLog record);

    int updateByPrimaryKey(BuyerLog record);
    
    //记录会员登录时日志
    int insert(@Param("sid") Long sid, @Param("record") BuyerLog record);
    
}