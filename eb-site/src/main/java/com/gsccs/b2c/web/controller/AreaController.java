package com.gsccs.b2c.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.domain.Area;
import com.gsccs.b2c.api.service.AreaServiceI;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.SsdbService;


/**
 * 地域管理控制类
 * @author x.d zhang
 *
 */
public class AreaController {
	
	@Autowired
	private AreaServiceI areaAPI;
	@Autowired
	private SsdbService cacheService;

	@ResponseBody
	@RequestMapping(value = "/{site}/areaList", method = RequestMethod.GET)
	public JsonMsg getAreaList(@PathVariable("site") Long siteId,Integer parid) {
		JsonMsg json = new JsonMsg();
		if (null==parid || parid==0){
			parid = 0;
		}
		List<Area> arealist = cacheService.getAreaByParId(parid);
		if (null==arealist || arealist.size()<=0){
			arealist = areaAPI.getArea(parid);
		}
		json.setSuccess(true);
		json.setData(arealist);
		return json;
	}

}
