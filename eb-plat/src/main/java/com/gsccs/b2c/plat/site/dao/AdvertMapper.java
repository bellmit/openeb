package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.AdvertExample;
import com.gsccs.eb.api.domain.site.Advert;

public interface AdvertMapper {

	int countByExample(AdvertExample example);

	int deleteByExample(AdvertExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Advert record);

	int insertSelective(Advert record);

	List<Advert> selectPageByExample(AdvertExample example);

	Advert selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Advert record,
			@Param("example") AdvertExample example);

	int updateByExample(@Param("record") Advert record,
			@Param("example") AdvertExample example);

	int updateByPrimaryKeySelective(Advert record);

	int updateByPrimaryKey(Advert record);
}