package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.common.service.AreaService;
import com.gsccs.eb.api.domain.base.Area;

/**
 * 
 * 地域服务层
 * 
 * @author x.d zhang
 */
public class AreaServiceAPI implements AreaServiceI {

	@Autowired
	private AreaService areaService;

	@Override
	public List<Area> getArea(Integer parid) {
		return areaService.queryByParId(parid);
	}

}
