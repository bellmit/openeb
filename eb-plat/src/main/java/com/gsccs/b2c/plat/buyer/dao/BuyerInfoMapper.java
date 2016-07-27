package com.gsccs.b2c.plat.buyer.dao;

import com.gsccs.b2c.plat.buyer.model.BuyerInfo;
import com.gsccs.b2c.plat.buyer.model.BuyerInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @说明  会员基本信息资料数据操作
 * @开发者 ma hong
 * @年月日 2015年4月8日
 * @时分秒 上午10:39:23
 */
public interface BuyerInfoMapper {
	
    int countByExample(BuyerInfoExample example);
    int deleteByExample(BuyerInfoExample example);

    //根据ID删除一条记录
    int deleteByPrimaryKey(Long id);
    
    int insertSelective(BuyerInfo record);
    //查询所有
    List<BuyerInfo> selectByExample(BuyerInfoExample example);
    //根据ID查询一条记录
    BuyerInfo selectByPrimaryKey(Long id);
    int updateByExampleSelective(@Param("record") BuyerInfo record, @Param("example") BuyerInfoExample example);
    int updateByExample(@Param("record") BuyerInfo record, @Param("example") BuyerInfoExample example);
    int updateByPrimaryKeySelective(BuyerInfo record);
    
    /*==================================================================================================================*/
    
    //根据ID更新一条记录
    int updateByPrimaryKey(@Param("sid")Long sid,@Param("record") BuyerInfo record);
    
    //插入会员个人信息     会员初次注册时  同时给会员个人信息表分配ID
    int insert(@Param("sid")Long sid,@Param("record")BuyerInfo record);
    
    
    
    
    
    
    
    
    
    
    
    
}