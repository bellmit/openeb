package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.SpecValMapper;
import com.gsccs.b2c.plat.shop.dao.SpecificMapper;
import com.gsccs.b2c.plat.shop.model.SpecVal;
import com.gsccs.b2c.plat.shop.model.Specific;
import com.gsccs.b2c.plat.shop.model.SpecificExample;

@Service
public class SpecServiceImpl implements SpecService {

	@Autowired
	private SpecificMapper specificMapper;
	@Autowired
	private SpecValMapper specValMapper;

	@Override
	public Long addSpecific(Specific spec) {
		if (null != spec) {
			specificMapper.insert(spec);
			Long specId = spec.getId();
			if (null != spec.getSpecVal() && spec.getSpecVal().size()>0){
				for (SpecVal sv:spec.getSpecVal()){
					sv.setSpecid(specId);
					specValMapper.insert(sv);
				}
			}
			return spec.getId();
		}
		return null;
	}

	@Override
	public void updateSpecific(Specific spec) {
		if (null != spec) {
			specificMapper.updateByPrimaryKey(spec);
		}
	}

	@Override
	public Specific getSpec(Long specId) {
		return specificMapper.selectByPrimaryKey(specId);
	}

	@Override
	public List<Specific> getSpecList(Specific spec, String order,
			int currPage, int pageSize) {
		SpecificExample example = new SpecificExample();
		SpecificExample.Criteria c = example.createCriteria();
		proSearchParam(spec,c);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return specificMapper.selectPageByExample(example);
	}

	@Override
	public int count(Specific spec) {
		SpecificExample example = new SpecificExample();
		SpecificExample.Criteria c = example.createCriteria();
		proSearchParam(spec,c);
		return specificMapper.countByExample(example);
	}

	public void proSearchParam(Specific spec, SpecificExample.Criteria c) {
		if (null != spec) {
			/*if (null != spec.getId()) {
				c.andIdEqualTo(spec.getId());
			}*/
			if (StringUtils.isNotEmpty(spec.getTitle())) {
				System.out.println(spec.getTitle());
				c.andTitleLike("'%" + spec.getTitle() + "%'");
			}
		}
	}

}
