package com.gsccs.b2c.plat.site.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.AdvertMapper;
import com.gsccs.b2c.plat.site.dao.AdvertSpaceMapper;
import com.gsccs.b2c.plat.site.model.AdvertExample;
import com.gsccs.b2c.plat.site.model.AdvertSpaceExample;
import com.gsccs.eb.api.domain.site.Advert;
import com.gsccs.eb.api.domain.site.AdvertSpace;

@Service("advertService")
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private AdvertMapper advertMapper;
	@Autowired
	private AdvertSpaceMapper advertSpaceMapper;

	@Override
	public void saveAdvert(Advert advert) {
		if (null == advert) {
			return;
		}

		// 默认平台广告
		if (advert.getShopid() == null) {
			advert.setShopid(0l);
		}

		if (null == advert.getId()) {
			advertMapper.insert(advert);
		} else {
			advertMapper.updateByPrimaryKeySelective(advert);
		}
	}

	@Override
	public Advert getAdvert(Long id) {
		return advertMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delAdvert(Long id) {
		advertMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<AdvertSpace> find(AdvertSpace param, String order,
			int currPage, int pageSize) {
		AdvertSpaceExample example = new AdvertSpaceExample();
		AdvertSpaceExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return advertSpaceMapper.selectPageByExample(example);
	}

	@Override
	public List<Advert> find(Advert param, String order, int currPage,
			int pageSize) {
		AdvertExample example = new AdvertExample();
		AdvertExample.Criteria criteria = example.createCriteria();
		proSearchParam(param, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		example.setOrderByClause("ordernum ");
		return advertMapper.selectPageByExample(example);
	}

	@Override
	public int count(Advert content) {
		AdvertExample example = new AdvertExample();
		AdvertExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		return advertMapper.countByExample(example);
	}

	@Override
	public void saveAdvertSpace(AdvertSpace space) {
		if (null == space) {
			return;
		}
		// 默认平台广告
		if (space.getShopid() == null) {
			space.setShopid(0l);
		}

		if (null == space.getId()) {
			advertSpaceMapper.insert(space);
		} else {
			advertSpaceMapper.updateByPrimaryKeySelective(space);
		}
	}

	@Override
	public AdvertSpace getAdvertSpace(Long id) {
		return advertSpaceMapper.selectByPrimaryKey(id);
	}

	public void proSearchParam(AdvertSpace param,
			AdvertSpaceExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getTitle())) {
				criteria.andTitleLike("%" + param.getTitle() + "%");
			}

			if (null != param.getApclass()) {
				criteria.andApclassEqualTo(param.getApclass());
			}

			if (null != param.getApdisplay()) {
				criteria.andApclassEqualTo(param.getApdisplay());
			}

			if (null != param.getState()) {
				criteria.andStateEqualTo(param.getState());
			}
		}

		if (null != param && null != param.getShopid()) {
			criteria.andShopidEqualTo(param.getShopid());
		} else {
			criteria.andShopidEqualTo(0l);
		}
	}

	public void proSearchParam(Advert param, AdvertExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getTitle())) {
				criteria.andTitleLike("%" + param.getTitle() + "%");
			}
			if (null != param.getSpaceid()) {
				criteria.andSpaceidEqualTo(param.getSpaceid());
			}
		}

		if (null != param && null != param.getShopid()) {
			criteria.andShopidEqualTo(param.getShopid());
		} else {
			criteria.andShopidEqualTo(0l);
		}
	}

}