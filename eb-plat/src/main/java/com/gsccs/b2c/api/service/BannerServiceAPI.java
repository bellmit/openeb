package com.gsccs.b2c.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.site.service.BannerService;
import com.gsccs.eb.api.domain.site.Banner;

public class BannerServiceAPI implements BannerServiceI {

	@Autowired
	private BannerService bannerService;

	@Override
	public Long addBanner(Long sid, Banner banner) {
		if (banner != null) {
			return bannerService.add(sid, banner);
		}
		return null;
	}

}
