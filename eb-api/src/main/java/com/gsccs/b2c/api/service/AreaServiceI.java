package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.base.Area;

/**
 * 地区位置选择
 */
public interface AreaServiceI {
	
	List<Area> getArea(Integer parid);
	
	
	
}
