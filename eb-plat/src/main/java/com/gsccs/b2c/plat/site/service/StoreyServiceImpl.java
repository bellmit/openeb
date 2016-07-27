package com.gsccs.b2c.plat.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.StoreyBannerMapper;
import com.gsccs.b2c.plat.site.dao.StoreyItemMapper;
import com.gsccs.b2c.plat.site.dao.StoreyListMapper;
import com.gsccs.b2c.plat.site.model.Storey;
import com.gsccs.b2c.plat.site.model.StoreyBanner;
import com.gsccs.b2c.plat.site.model.StoreyBannerExample;
import com.gsccs.b2c.plat.site.model.StoreyItem;
import com.gsccs.b2c.plat.site.model.StoreyItemExample;
import com.gsccs.b2c.plat.site.model.StoreyList;
import com.gsccs.b2c.plat.site.model.StoreyListExample;
import com.gsccs.b2c.plat.site.model.StoreyListExample.Criteria;

@Service
public class StoreyServiceImpl implements StoreyService {

	@Autowired
	private StoreyListMapper storeyListMapper;
	@Autowired
	private StoreyItemMapper storeyItemMapper;
	@Autowired
	private StoreyBannerMapper storeyBannerMapper;

	@Override
	public boolean addStorey(Long siteId, StoreyList storey,
			List<StoreyItem> items) {
		boolean result = true;
		try {
			if (storey != null) {
				storeyListMapper.insert(storey);
			}
			if (null != items) {
				for (StoreyItem item : items) {
					storeyItemMapper.insert(item);
				}
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public List<StoreyList> findStoreyList(Long siteid) {
		StoreyListExample example = new StoreyListExample();
		Criteria criteria = example.createCriteria();
		criteria.andSiteidEqualTo(siteid);
		return storeyListMapper.selectByExample(example);
	}

	@Override
	public List<StoreyItem> findStoreyItems(Long siteid) {
		StoreyItemExample example = new StoreyItemExample();
		StoreyItemExample.Criteria criteria = example.createCriteria();
		criteria.andSiteidEqualTo(siteid);
		return storeyItemMapper.selectByExample(example);
	}

	@Override
	public List<StoreyBanner> findStoreyBanners(Long siteid) {
		StoreyBannerExample example = new StoreyBannerExample();
		StoreyBannerExample.Criteria criteria = example.createCriteria();
		criteria.andSiteidEqualTo(siteid);
		return storeyBannerMapper.selectByExample(example);
	}

	@Override
	public boolean deleteStorey(Long siteId, String storeyid) {
		boolean result = true;
		try {
			StoreyItemExample example = new StoreyItemExample();
			StoreyItemExample.Criteria criteria = example.createCriteria();
			criteria.andSiteidEqualTo(siteId);
			criteria.andStoreyidEqualTo(storeyid);
			storeyItemMapper.deleteByExample(example);
			storeyListMapper.deleteByPrimaryKey(storeyid);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	@Override
	public boolean addBanners(Long siteId, List<StoreyBanner> items) {
		boolean result = true;
		try {
			if (null != items) {
				for (StoreyBanner banner : items) {
					storeyBannerMapper.insert(banner);
				}
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

}
