package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.AlbumMapper;
import com.gsccs.eb.api.domain.goods.Album;

@Service
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumMapper albumMapper;
	
	@Override
	public List<Album> getImgByPid(Long siteid, Long pid) {
		return albumMapper.selectByPid(siteid, pid);
	}

	@Override
	public Long[] addListImg(Long sid, List<Album> pitList) {
		if (null != pitList && pitList.size() > 0) {
			Long[] ids = new Long[pitList.size()];
			int i = 0;
			for (Album pt : pitList) {
				albumMapper.insert(sid, pt);
				ids[i] = pt.getId();
				i++;
			}
			return ids;
		}
		return null;
	}

}
