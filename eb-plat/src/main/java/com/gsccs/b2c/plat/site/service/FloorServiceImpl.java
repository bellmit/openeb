package com.gsccs.b2c.plat.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.BannerMapper;
import com.gsccs.b2c.plat.site.dao.FloorMapper;
import com.gsccs.b2c.plat.site.dao.StoreyListMapper;
import com.gsccs.b2c.plat.site.model.BannerExample;
import com.gsccs.b2c.plat.site.model.FloorExample;
import com.gsccs.b2c.plat.site.model.StoreyList;
import com.gsccs.b2c.plat.site.model.StoreyListExample;
import com.gsccs.b2c.plat.site.model.StoreyListExample.Criteria;
import com.gsccs.eb.api.domain.site.Banner;
import com.gsccs.eb.api.domain.site.Floor;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private StoreyListMapper storeyListMapper;
	@Autowired
	private FloorMapper storeyItemMapper;
	@Autowired
	private BannerMapper storeyBannerMapper;

	@Override
	public boolean addStorey(Long siteId, StoreyList storey,
			List<Floor> items) {
		boolean result = true;
		try {
			if (storey != null) {
				storeyListMapper.insert(storey);
			}
			if (null != items) {
				for (Floor item : items) {
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
	public List<Floor> findStoreyItems(Long siteid) {
		FloorExample example = new FloorExample();
		FloorExample.Criteria criteria = example.createCriteria();
		criteria.andSiteidEqualTo(siteid);
		return storeyItemMapper.selectByExample(example);
	}

	@Override
	public List<Banner> findStoreyBanners(Long siteid) {
		BannerExample example = new BannerExample();
		BannerExample.Criteria criteria = example.createCriteria();
		criteria.andSiteidEqualTo(siteid);
		return storeyBannerMapper.selectByExample(example);
	}

	@Override
	public boolean deleteStorey(Long siteId, String storeyid) {
		boolean result = true;
		try {
			FloorExample example = new FloorExample();
			FloorExample.Criteria criteria = example.createCriteria();
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
	public boolean addBanners(Long siteId, List<Banner> items) {
		boolean result = true;
		try {
			if (null != items) {
				for (Banner banner : items) {
					storeyBannerMapper.insert(banner);
				}
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

}
