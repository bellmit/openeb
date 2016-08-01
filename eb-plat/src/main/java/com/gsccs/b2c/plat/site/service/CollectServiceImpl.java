package com.gsccs.b2c.plat.site.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.model.CollectStatist;
import com.gsccs.b2c.plat.site.dao.CollectMapper;
import com.gsccs.b2c.plat.site.model.CollectExample;
import com.gsccs.b2c.plat.site.model.CollectExample.Criteria;
import com.gsccs.eb.api.domain.site.Collect;

/**
 * 收藏数据接口
 * 
 * @author x.d zhang
 * 
 */
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectMapper collectTMapper;

	@Override
	public void addCollect(Collect collect) {
		if (null != collect) {
			collect.setId(UUID.randomUUID().toString());
			collect.setAddtime(new Date());
			collectTMapper.insert(collect);
		}
	}

	@Override
	public void delCollect(String id) {
		collectTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Collect> getCollectProducts(Collect collect, int page,
			int pagesize) {
		CollectExample example = new CollectExample();
		Criteria criteria = example.createCriteria();
		if (null != collect) {
			proSearchParam(collect, criteria);
		}
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return collectTMapper.selectProductList(example);
	}

	@Override
	public List<Collect> getCollectBrands(Collect collect, int page,
			int pagesize) {
		CollectExample example = new CollectExample();
		Criteria criteria = example.createCriteria();
		if (null != collect) {
			proSearchParam(collect, criteria);
		}
		example.setCurrPage(page);
		example.setPageSize(pagesize);
		return collectTMapper.selectBrandList(example);
	}

	/**
	 * 处理查询条件
	 * 
	 * @param evalItemT
	 * @param criteria
	 */
	public void proSearchParam(Collect collectT,
			CollectExample.Criteria criteria) {
		if (null != collectT) {

			if (collectT.getId() != null) {
				criteria.andIdEqualTo(collectT.getId());
			}
			if (collectT.getSiteid() != null) {
				criteria.andSiteidEqualTo(collectT.getSiteid());
			}

			if (collectT.getBuyerid() != null) {
				criteria.andBuyeridEqualTo(collectT.getBuyerid());
			}

			/*
			 * if (collectT.getColltype() != null) {
			 * criteria.andTypeEqualTo(collectT.getColltype()); }
			 */
		}
	}

	@Override
	public List<CollectStatist> collectStatist(Long siteid, Long buyerid) {
		return collectTMapper.collectStatist(siteid, buyerid);
	}

}
