package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.eb.api.domain.site.Navigation;

/**
 * 首页Banner管理
 * 
 * @author ZhangTao
 * 
 */
public interface NavigationService {

	/**
	 * 添加
	 * 
	 * @param navigation
	 * @return
	 */
	public void add(Navigation navigation);

	/**
	 * 查询导航列表
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Navigation> findnavList(Navigation param, int page, int rows);

}
