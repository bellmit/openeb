package com.gsccs.b2c.plat.site.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.NavigationMapper;
import com.gsccs.b2c.plat.site.model.NavigationExample;
import com.gsccs.eb.api.domain.site.Navigation;

@Service
public class NavigtaionServiceImpl implements NavigationService {

	@Autowired
	private NavigationMapper navigationMapper;

	@Override
	public void save(Navigation nav) {
		if (nav == null) {
			return;
		}
		if (StringUtils.isEmpty(nav.getId())) {
			navigationMapper.insert(nav);
		} else {
			navigationMapper.updateByPrimaryKey(nav);
		}
	}

	@Override
	public Navigation get(String id) {
		if(StringUtils.isEmpty(id)){
			return null;
		}
		return navigationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Navigation> findnavList(Navigation param, int page, int rows) {
		NavigationExample example = new NavigationExample();
		NavigationExample.Criteria c = example.createCriteria();
		proSearchParam(param, c);
		return navigationMapper.selectByExample(example);
	}

	/**
	 * 处理查询条件
	 * 
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(Navigation param,
			NavigationExample.Criteria criteria) {
		if (param != null) {
			if (StringUtils.isNotEmpty(param.getTitle())) {
				criteria.andTitleLike("%" + param.getTitle() + "%");
			}

			if (StringUtils.isNotEmpty(param.getBlank())) {
				criteria.andBlankEqualTo(param.getBlank());
			}

			if (StringUtils.isNotEmpty(param.getHidden())) {
				criteria.andHiddenEqualTo(param.getHidden());
			}

			if (null == param.getShopid()) {
				criteria.andShopidEqualTo(param.getShopid());
			}
		}
	}

}
