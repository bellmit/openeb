package com.gsccs.b2c.plat.site.dao;

import com.gsccs.b2c.plat.site.model.AreaTemplate;
import com.gsccs.b2c.plat.site.model.AreaTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


/**
 * @说明     指定区域运费模板数据操作映射方法
 * @开发者 ma hong
 * @年月日 2015年4月27日
 * @时分秒 下午3:08:38
 */
public interface AreaTemplateMapper {
	
    int countByExample(AreaTemplateExample example);

    int deleteByExample(AreaTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AreaTemplate record);

    int insertSelective(AreaTemplate record);

    List<AreaTemplate> selectByExample(AreaTemplateExample example);

    AreaTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AreaTemplate record, @Param("example") AreaTemplateExample example);

    int updateByExample(@Param("record") AreaTemplate record, @Param("example") AreaTemplateExample example);

    int updateByPrimaryKeySelective(AreaTemplate record);

    int updateByPrimaryKey(AreaTemplate record);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}