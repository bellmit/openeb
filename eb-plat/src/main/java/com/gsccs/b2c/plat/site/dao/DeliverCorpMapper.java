package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.DeliverCorpT;
import com.gsccs.b2c.plat.site.model.DeliverCorpTExample;

/**
 * @说明   物流公司登记数据操作类
 * @开发者 ma hong
 * @年月日 2015年4月23日
 * @时分秒 上午9:56:02
 */
public interface DeliverCorpMapper {
	
    int countByExample(DeliverCorpTExample example);

    int deleteByExample(DeliverCorpTExample example);

    int insertSelective(DeliverCorpT record);

    int updateByExampleSelective(@Param("record") DeliverCorpT record, @Param("example") DeliverCorpTExample example);

    int updateByExample(@Param("record") DeliverCorpT record, @Param("example") DeliverCorpTExample example);

    int updateByPrimaryKeySelective(DeliverCorpT record);
    
    List<DeliverCorpT> selectByExample(DeliverCorpTExample example);

    List<DeliverCorpT> selectPageByExample(DeliverCorpTExample example);

    
    //物流公司信息保存
    int insert(DeliverCorpT record);
    
    //根据ID更新物流公司信息
    int updateByPrimaryKey(DeliverCorpT record);
    
    //根据ID删除物流公司信息
    int deleteByPrimaryKey(Integer id);
    
    //根据ID查询一条物流公司信息
    DeliverCorpT selectByPrimaryKey(Integer id);
    
    //查询所有
    List<DeliverCorpT> selectAll();
    
    
}