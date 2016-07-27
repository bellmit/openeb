package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.b2c.plat.site.model.StoreyBanner;
import com.gsccs.b2c.plat.site.model.StoreyItem;
import com.gsccs.b2c.plat.site.model.StoreyList;

/**
 * 首页楼层管理
 * @author ZhangTao
 *
 */
public interface StoreyService {

	/**
	 * 添加楼层
	 * @param siteId
	 * @param StoreyList
	 * @return
	 */
	public boolean addStorey(Long siteId, StoreyList storeyList,List<StoreyItem> items);
	
	public boolean addBanners(Long siteId, List<StoreyBanner> items);
	
	/**
	 * 删除楼层
	 * @param siteId
	 * @param storeyid
	 * @return
	 */
	public boolean deleteStorey(Long siteId, String storeyid);
	
	/**
	 * 获取楼层列表
	 * @param siteid
	 * @return
	 */
	public List<StoreyList> findStoreyList(Long siteid);
	
	/**
	 * 获取楼层内容
	 * @param siteid
	 * @return
	 */
	public List<StoreyItem> findStoreyItems(Long siteid);
	
	/**
	 * 获取楼层banner
	 * @param siteid
	 * @return
	 */
	public List<StoreyBanner> findStoreyBanners(Long siteid);
	
}
