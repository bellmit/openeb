package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.b2c.plat.site.model.StoreyList;
import com.gsccs.eb.api.domain.site.Banner;
import com.gsccs.eb.api.domain.site.Floor;

/**
 * 首页楼层管理
 * @author ZhangTao
 *
 */
public interface FloorService {

	/**
	 * 添加楼层
	 * @param siteId
	 * @param StoreyList
	 * @return
	 */
	public boolean addStorey(Long siteId, StoreyList storeyList,List<Floor> items);
	
	public boolean addBanners(Long siteId, List<Banner> items);
	
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
	public List<Floor> findStoreyItems(Long siteid);
	
	/**
	 * 获取楼层banner
	 * @param siteid
	 * @return
	 */
	public List<Banner> findStoreyBanners(Long siteid);
	
}
