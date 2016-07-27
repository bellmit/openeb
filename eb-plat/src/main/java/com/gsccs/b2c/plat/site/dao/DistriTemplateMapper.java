package com.gsccs.b2c.plat.site.dao;

import com.gsccs.b2c.plat.site.model.DistriTemplate;
import com.gsccs.b2c.plat.site.model.DistriTemplateExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @说明     自定义运费模板数据操作映射方法
 * @开发者 ma hong
 * @年月日 2015年4月27日
 * @时分秒 下午3:09:34
 */
public interface DistriTemplateMapper {
	
    int countByExample(DistriTemplateExample example);

    int deleteByExample(DistriTemplateExample example);

    int deleteByPrimaryKey(Integer id);

   /* int insert(DistriTemplate record);*/

    int insertSelective(DistriTemplate record);

    List<DistriTemplate> selectByExample(DistriTemplateExample example);

    DistriTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DistriTemplate record, @Param("example") DistriTemplateExample example);

    int updateByExample(@Param("record") DistriTemplate record, @Param("example") DistriTemplateExample example);

    int updateByPrimaryKeySelective(DistriTemplate record);

    int updateByPrimaryKey(DistriTemplate record);
    
    /*ID自增*/
 	long selectMaxId(@Param("sid") Long sid);
    
    /*保存一条物流运费模板信息*/
    int insert(@Param("sid")Long sid,@Param("record")DistriTemplate record);
    
    
}