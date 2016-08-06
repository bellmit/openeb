package com.gsccs.b2c.plat.deliver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.deliver.model.CorpExample;
import com.gsccs.eb.api.domain.deliver.Corp;

/**
 * @说明   物流公司登记数据操作类
 * @开发者 ma hong
 * @年月日 2015年4月23日
 * @时分秒 上午9:56:02
 */
public interface DeliverCorpMapper {
	
    int countByExample(CorpExample example);

    int deleteByExample(CorpExample example);

    int insertSelective(Corp record);

    int updateByExampleSelective(@Param("record") Corp record, @Param("example") CorpExample example);

    int updateByExample(@Param("record") Corp record, @Param("example") CorpExample example);

    int updateByPrimaryKeySelective(Corp record);
    
    List<Corp> selectByExample(CorpExample example);

    List<Corp> selectPageByExample(CorpExample example);

    
    //物流公司信息保存
    int insert(Corp record);
    
    //根据ID更新物流公司信息
    int updateByPrimaryKey(Corp record);
    
    //根据ID删除物流公司信息
    int deleteByPrimaryKey(Integer id);
    
    //根据ID查询一条物流公司信息
    Corp selectByPrimaryKey(Integer id);
    
    //查询所有
    List<Corp> selectAll();
    
    
}