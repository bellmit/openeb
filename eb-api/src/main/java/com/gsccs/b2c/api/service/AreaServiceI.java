package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.b2c.api.domain.Area;

/**
 * 地区位置选择
 */
public interface AreaServiceI {
	
	List<Area> getArea(Integer parid);
	
	
	
}
