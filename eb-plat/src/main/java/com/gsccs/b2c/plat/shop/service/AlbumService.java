package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import com.gsccs.eb.api.domain.goods.Album;

/**
 * 商品图片接口
 * 
 * @author niu x j
 * 
 */
public interface AlbumService {

	public List<Album> getImgByPid(Long siteid, Long pid);

	public Long[] addListImg(Long sid, List<Album> pitList);

}
