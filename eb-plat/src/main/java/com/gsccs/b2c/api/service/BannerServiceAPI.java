package com.gsccs.b2c.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.domain.Banner;
import com.gsccs.b2c.plat.site.service.BannerService;

public class BannerServiceAPI implements BannerServiceI {

	@Autowired
	private BannerService bannerService;
	
	@Override
	public Long addBanner(Long sid, Banner banner) {
		if(banner != null) {
			com.gsccs.b2c.plat.site.model.Banner bann = new com.gsccs.b2c.plat.site.model.Banner();
			BeanUtils.copyProperties(banner, bann);
			
			return bannerService.add(sid, bann);
		}
		return null;
	}

}
