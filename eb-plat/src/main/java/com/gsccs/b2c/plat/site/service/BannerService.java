package com.gsccs.b2c.plat.site.service;

import com.gsccs.eb.api.domain.site.Banner;

/**
 * 首页Banner管理
 * @author ZhangTao
 *
 */
public interface BannerService {

	/**
	 * 添加
	 * @param siteId
	 * @param storey
	 * @return
	 */
	public Long add(Long siteId, Banner banner);
	
}
