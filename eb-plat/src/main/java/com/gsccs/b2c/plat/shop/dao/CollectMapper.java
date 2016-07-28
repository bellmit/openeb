package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.CollectExample;
import com.gsccs.b2c.plat.shop.model.CollectStatist;
import com.gsccs.eb.api.domain.site.Collect;

public interface CollectMapper {
	
    int countByExample(CollectExample example);
    int deleteByExample(CollectExample example);
    int deleteByPrimaryKey(String id);
    int insert(Collect record);
    List<Collect> selectByExample(CollectExample example);
    Collect selectByPrimaryKey(String id);
    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);
    int updateByPrimaryKey(Collect record);
    List<Collect>  selectProductList(CollectExample example);
    List<Collect>  selectBrandList(CollectExample example);
    List<CollectStatist> collectStatist(@Param("siteid") Long siteid,@Param("buyerid") Long buyerid);
}