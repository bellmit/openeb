package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.BrandMapper;
import com.gsccs.b2c.plat.shop.dao.StoreCateMapper;
import com.gsccs.b2c.plat.shop.model.BrandT;
import com.gsccs.b2c.plat.shop.model.BrandTExample;
import com.gsccs.b2c.plat.shop.model.StoreCate;
import com.gsccs.b2c.plat.shop.model.StoreCateExample;
import com.gsccs.b2c.plat.shop.model.BrandTExample.Criteria;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private StoreCateMapper storeCateMapper;

	@Override
	public List<BrandT> find(BrandT brands, String order, int currPage,
			int pageSize, boolean iscache) {
		BrandTExample example = new BrandTExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(brands, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return brandMapper.selectPageByExample(example);
	}

	@Override
	public List<BrandT> find(BrandT brands, String order) {
		BrandTExample example = new BrandTExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(brands, criteria);
		return brandMapper.selectByExample(example);
	}

	@Override
	public int count(BrandT brands, boolean iscache) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BrandT findById(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(BrandT brands) {

	}

	@Override
	public Long add(BrandT brands) {
		if (null != brands) {
			brandMapper.insert(brands);
			return brands.getId();
		}
		return null;
	}

	@Override
	public void del(Long id) {
		brandMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 处理查询条件
	 * 
	 * @param info
	 * @param criteria
	 */
	public void proSearchParam(BrandT brand, Criteria criteria) {
		if (brand != null) {
			if (brand.getId() != null) {
				criteria.andIdEqualTo(brand.getId());
			}

			if (brand.getName() != null && brand.getName().trim().length() > 0) {
				criteria.andNameLike("%" + brand.getName() + "%");
			}

			if (StringUtils.isNotEmpty(brand.getState())) {
				criteria.andStateEqualTo(brand.getState());
			}

		}
	}

	@Override
	public int count(BrandT brands) {
		BrandTExample example = new BrandTExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(brands, criteria);
		return brandMapper.countByExample(example);
	}

	@Override
	public List<BrandT> findStoreBrand(Long sid, int currPage, int pageSize,
			boolean iscache) {
		StoreCateExample e1 = new StoreCateExample();
		StoreCateExample.Criteria c1 = e1.createCriteria();
		c1.andSiteIdEqualTo(sid);
		StoreCate storeCate = storeCateMapper.selectByPrimaryKey(sid);
		if (null != storeCate
				&& StringUtils.isNotEmpty(storeCate.getBrandids())) {
			BrandTExample example = new BrandTExample();
			BrandTExample.Criteria c = example.createCriteria();
			c.andSQL(" id in (" + storeCate.getBrandids() + ")");
			example.setCurrPage(currPage);
			example.setPageSize(pageSize);
			return brandMapper.selectPageByExample(example);
		}
		return null;
	}
}
