package com.gsccs.b2c.plat.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.BannerMapper;
import com.gsccs.b2c.plat.site.model.Banner;


@Service
public class BannerServiceImpl implements BannerService {
	
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public Long add(Long siteId, Banner banner) {
		if(banner != null) {
			return (long) bannerMapper.insert(siteId, banner);
		}
		return null;
	}

}
