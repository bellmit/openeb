package com.gsccs.b2c.api.service;

import com.gsccs.eb.api.domain.site.Banner;

/**
 * 首页Banner
 * @author ZhangTao
 *
 */
public interface BannerServiceI {

	/** 
	 * 添加Banner信息
	 * @param sid
	 * @param banner
	 * @return
	 */
	public Long addBanner(Long sid, Banner banner);
	
}
