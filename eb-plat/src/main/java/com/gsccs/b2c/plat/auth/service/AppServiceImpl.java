package com.gsccs.b2c.plat.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.auth.dao.AppMapper;
import com.gsccs.b2c.plat.auth.model.App;
import com.gsccs.b2c.plat.auth.model.AppExample;
import com.gsccs.b2c.plat.auth.model.AppExample.Criteria;

/**
 * 
 * @author x.d zhang
 *
 */
@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AppMapper appMapper;

	public App createApp(App app) {
		appMapper.insert(app);
		return appMapper.selectByPrimaryKey(app.getId());
	}

	public App updateApp(App app) {
		appMapper.updateByPrimaryKey(app);
		return appMapper.selectByPrimaryKey(app.getId());
	}

	public void deleteApp(Long appId) {
		appMapper.deleteByPrimaryKey(appId);
	}

	@Override
	public App findOne(Long appId) {
		return appMapper.selectByPrimaryKey(appId);
	}

	@Override
	public List<App> findAll() {
		AppExample example = new AppExample();
		Criteria c = example.createCriteria();

		return appMapper.selectByExample(example);
	}

	@Override
	public Long findAppIdByAppKey(String appKey) {
		AppExample example = new AppExample();
		Criteria c = example.createCriteria();
		c.andAppKeyEqualTo(appKey);
		List<App> applist = appMapper.selectByExample(example);
		if (null != applist && applist.size() > 0) {
			return applist.get(0).getId();
		}
		return null;
	}
}
