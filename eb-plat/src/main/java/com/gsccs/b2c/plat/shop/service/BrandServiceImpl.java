package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.BrandMapper;
import com.gsccs.b2c.plat.shop.dao.StoreCateMapper;
import com.gsccs.b2c.plat.shop.model.BrandExample;
import com.gsccs.b2c.plat.shop.model.BrandExample.Criteria;
import com.gsccs.b2c.plat.shop.model.StoreCate;
import com.gsccs.b2c.plat.shop.model.StoreCateExample;
import com.gsccs.eb.api.domain.goods.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private StoreCateMapper storeCateMapper;

	@Override
	public List<Brand> find(Brand brands, String order, int currPage,
			int pageSize, boolean iscache) {
		BrandExample example = new BrandExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(brands, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return brandMapper.selectPageByExample(example);
	}

	@Override
	public List<Brand> find(Brand brands, String order) {
		BrandExample example = new BrandExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(brands, criteria);
		return brandMapper.selectByExample(example);
	}

	@Override
	public int count(Brand brands, boolean iscache) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Brand findById(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(Brand brands) {

	}

	@Override
	public Long add(Brand brands) {
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
	public void proSearchParam(Brand brand, Criteria criteria) {
		if (brand != null) {
			if (brand.getId() != null) {
				criteria.andIdEqualTo(brand.getId());
			}

			if (brand.getShopid() != null) {
				criteria.andShopidEqualTo(brand.getShopid());
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
	public int count(Brand brands) {
		BrandExample example = new BrandExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(brands, criteria);
		return brandMapper.countByExample(example);
	}

	@Override
	public List<Brand> findStoreBrand(Long sid, int currPage, int pageSize,
			boolean iscache) {
		StoreCateExample e1 = new StoreCateExample();
		StoreCateExample.Criteria c1 = e1.createCriteria();
		c1.andSiteIdEqualTo(sid);
		StoreCate storeCate = storeCateMapper.selectByPrimaryKey(sid);
		if (null != storeCate
				&& StringUtils.isNotEmpty(storeCate.getBrandids())) {
			BrandExample example = new BrandExample();
			BrandExample.Criteria c = example.createCriteria();
			c.andSQL(" id in (" + storeCate.getBrandids() + ")");
			example.setCurrPage(currPage);
			example.setPageSize(pageSize);
			return brandMapper.selectPageByExample(example);
		}
		return null;
	}
}
