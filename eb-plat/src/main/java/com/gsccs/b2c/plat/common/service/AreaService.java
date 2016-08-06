package com.gsccs.b2c.plat.common.service;

import java.util.List;

import com.gsccs.eb.api.domain.base.Area;

/**
 */
public interface AreaService {

	List<Area> queryByParId(Integer parentid);

	/**
	 * 分页查询
	 */
	public List<Area> find(Area area, String order, int currPage, int pageSize);

	public int count(Area area);

}
