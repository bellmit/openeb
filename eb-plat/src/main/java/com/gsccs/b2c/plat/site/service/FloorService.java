package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.b2c.plat.site.model.StoreyList;
import com.gsccs.eb.api.domain.site.Banner;
import com.gsccs.eb.api.domain.site.Floor;

/**
 * 首页楼层管理
 * 
 * @author ZhangTao
 * 
 */
public interface FloorService {

	/**
	 * 添加楼层
	 * 
	 * @param floor
	 * @return
	 */
	public void saveFloor(Floor floor);

	/**
	 * 删除楼层
	 * 
	 * @param storeyid
	 * @return
	 */
	public boolean deleteFloor(String id);

	public Floor getFloor(String id);

	/**
	 * 获取楼层列表
	 * 
	 * @param siteid
	 * @return
	 */
	public List<Floor> findFloorList(Long shopid);

	/**
	 * 获取楼层banner
	 * 
	 * @param siteid
	 * @return
	 */
	public List<Banner> findBannerList(Long shopid);

	public boolean addBanners(Long siteId, List<Banner> items);

}
