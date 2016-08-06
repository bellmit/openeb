package com.gsccs.b2c.plat.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.shop.model.AlbumExample;
import com.gsccs.eb.api.domain.goods.Album;

public interface AlbumMapper {
	
    int countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(@Param("sid") Long sid, @Param("record") Album record);

    int insertSelective(Album record);

    List<Album> selectByExample(AlbumExample example);
    
    List<Album> selectByPid(@Param("sid") Long sid,
			@Param("productId") Long productId  );

    Album selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);
}