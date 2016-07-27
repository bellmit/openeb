package com.gsccs.b2c.plat.shop.dao;

import com.gsccs.b2c.plat.shop.model.CollectStatist;
import com.gsccs.b2c.plat.shop.model.CollectT;
import com.gsccs.b2c.plat.shop.model.CollectTExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
	
    int countByExample(CollectTExample example);
    int deleteByExample(CollectTExample example);
    int deleteByPrimaryKey(String id);
    int insert(CollectT record);
    List<CollectT> selectByExample(CollectTExample example);
    CollectT selectByPrimaryKey(String id);
    int updateByExample(@Param("record") CollectT record, @Param("example") CollectTExample example);
    int updateByPrimaryKey(CollectT record);
    List<CollectT>  selectProductList(CollectTExample example);
    List<CollectT>  selectBrandList(CollectTExample example);
    List<CollectStatist> collectStatist(@Param("siteid") Long siteid,@Param("buyerid") Long buyerid);
}