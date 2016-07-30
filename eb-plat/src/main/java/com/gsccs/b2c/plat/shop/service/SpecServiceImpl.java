package com.gsccs.b2c.plat.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.SpecValMapper;
import com.gsccs.b2c.plat.shop.dao.SpecificMapper;
import com.gsccs.b2c.plat.shop.model.SpecValExample;
import com.gsccs.b2c.plat.shop.model.SpecificExample;
import com.gsccs.eb.api.domain.goods.SpecVal;
import com.gsccs.eb.api.domain.goods.Specific;

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
			if (null != spec.getSpecVals() && spec.getSpecVals().size() > 0) {
				for (SpecVal sv : spec.getSpecVals()) {
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
			//更新规格
			specificMapper.updateByPrimaryKey(spec);
			
			//更新规格值
			List<Long> specvalids = new ArrayList<Long>();
			if (null != spec.getSpecVals() && spec.getSpecVals().size() > 0) {
				for (SpecVal sv : spec.getSpecVals()) {
					if (sv.getId()==null){
						sv.setSpecid(spec.getId());
						specValMapper.insert(sv);
					}else{
						sv.setSpecid(spec.getId());
						specValMapper.updateByPrimaryKey(sv);
					}
					specvalids.add(sv.getId());
				}
			}
			
			//删除失效规格值
			SpecValExample example = new SpecValExample();
			SpecValExample.Criteria c = example.createCriteria();
			c.andSpecidEqualTo(spec.getId());
			c.andIdNotIn(specvalids);
			specValMapper.deleteByExample(example);
		}
	}

	@Override
	public void deleteSpecific(Long id) {
		specificMapper.deleteByPrimaryKey(id);
		SpecValExample example = new SpecValExample();
		SpecValExample.Criteria c = example.createCriteria();
		c.andSpecidEqualTo(id);
		specValMapper.deleteByExample(example);
	}

	@Override
	public void deleteSpecVal(Long id) {
		specValMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Specific getSpec(Long specId) {
		Specific specific = specificMapper.selectByPrimaryKey(specId);
		if (null != specific) {
			List<SpecVal> specVals = specValMapper.selectBySpecid(specId);
			specific.setSpecVals(specVals);
		}
		return specific;
	}

	@Override
	public List<Specific> queryBySpecName(String specname) {
		if (StringUtils.isEmpty(specname)) {
			return null;
		} else {
			SpecificExample example = new SpecificExample();
			SpecificExample.Criteria c = example.createCriteria();
			c.andTitleEqualTo(specname);
			example.setCurrPage(1);
			example.setPageSize(Integer.MAX_VALUE);
			return specificMapper.selectPageByExample(example);
		}
	}

	@Override
	public List<Specific> getSpecList(Specific spec, String order,
			int currPage, int pageSize) {
		SpecificExample example = new SpecificExample();
		SpecificExample.Criteria c = example.createCriteria();
		proSearchParam(spec, c);
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
		proSearchParam(spec, c);
		return specificMapper.countByExample(example);
	}

	public void proSearchParam(Specific spec, SpecificExample.Criteria c) {
		if (null != spec) {
			if (StringUtils.isNotEmpty(spec.getTitle())) {
				c.andTitleLike("'%" + spec.getTitle() + "%'");
			}
		}
	}

}
