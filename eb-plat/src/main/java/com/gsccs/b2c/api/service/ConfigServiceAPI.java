package com.gsccs.b2c.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.common.model.Config;
import com.gsccs.b2c.plat.common.service.ConfigService;

public class ConfigServiceAPI implements ConfigServiceI {
	
	@Autowired
	private ConfigService configService;

	@Override
	public String getConfigVal(String key) {
		Config conf = configService.findByCode(key);
		return conf.getConfigvalue();
	}

}
