package com.gsccs.b2c.api.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.api.domain.Area;
import com.gsccs.b2c.plat.site.model.AreaT;
import com.gsccs.b2c.plat.site.service.AreaService;

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
		List<AreaT> list = areaService.getByParId(parid);

		List<Area> domianList = new ArrayList<Area>();
		Area domain = null;

		for (AreaT t : list) {
			domain = new Area();
			try {
				BeanUtils.copyProperties(domain, t);
				domianList.add(domain);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return domianList;
	}

}
