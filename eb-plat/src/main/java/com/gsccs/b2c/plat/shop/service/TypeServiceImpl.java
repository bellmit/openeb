package com.gsccs.b2c.plat.shop.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.shop.dao.PropertyMapper;
import com.gsccs.b2c.plat.shop.dao.PropsValMapper;
import com.gsccs.b2c.plat.shop.dao.RequirInfoMapper;
import com.gsccs.b2c.plat.shop.dao.SpecValMapper;
import com.gsccs.b2c.plat.shop.dao.SpecificMapper;
import com.gsccs.b2c.plat.shop.dao.TypeMapper;
import com.gsccs.b2c.plat.shop.dao.TypeParamMapper;
import com.gsccs.b2c.plat.shop.dao.TypeSpecMapper;
import com.gsccs.b2c.plat.shop.model.PropertyExample;
import com.gsccs.b2c.plat.shop.model.PropsValExample;
import com.gsccs.b2c.plat.shop.model.SpecValExample;
import com.gsccs.b2c.plat.shop.model.TypeExample;
import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.PropsVal;
import com.gsccs.eb.api.domain.goods.RequirInfo;
import com.gsccs.eb.api.domain.goods.SpecVal;
import com.gsccs.eb.api.domain.goods.Specific;
import com.gsccs.eb.api.domain.goods.Type;
import com.gsccs.eb.api.domain.goods.TypeParam;
import com.gsccs.eb.api.domain.goods.TypeSpec;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private PropertyMapper propertyMapper;
	@Autowired
	private SpecificMapper specificMapper;
	@Autowired
	private SpecValMapper specValMapper;
	@Autowired
	private TypeSpecMapper typeSpecMapper;
	@Autowired
	private TypeMapper typeMapper;
	@Autowired
	private TypeParamMapper detailParamMapper;
	@Autowired
	private RequirInfoMapper requirInfoMapper;
	@Autowired
	private PropsValMapper propvalTMapper;

	@Override
	public List<Specific> getSpecList(Long typeId) {
		return specificMapper.selectByType(typeId);
	}

	@Override
	public List<Property> getPropList(Long typeId) {
		PropertyExample example = new PropertyExample();
		PropertyExample.Criteria c = example.createCriteria();
		c.andTypeIdEqualTo(typeId);
		return propertyMapper.selectByExample(example);
	}

	@Override
	public Long addSpecific(Specific spec) {
		if (null != spec) {
			specificMapper.insert(spec);
			return spec.getId();
		}
		return null;
	}

	@Override
	public Long addType(Type type) {
		Long typeId = null;
		if (null != type) {
			typeMapper.insert(type);
			typeId = type.getId();

			if (null != type.getProps() && type.getProps().size() > 0) {
				for (Property prop : type.getProps()) {
					prop.setTypeId(typeId);
					propertyMapper.insert(prop);
				}
			}

			if (null != type.getSpecs() && type.getSpecs().size() > 0) {
				TypeSpec ts;
				for (Specific spec : type.getSpecs()) {
					ts = new TypeSpec();
					ts.setTypeId(typeId);
					ts.setSpecId(spec.getId());
					ts.setShowModel(spec.getShowModel());
					ts.setOrdernum(spec.getOrdernum());
					typeSpecMapper.insert(ts);
				}
			}

			// 存在BUG
			if (null != type.getParams() && type.getParams().size() > 0) {
				for (TypeParam param : type.getParams()) {
					param.setTypeId(typeId);
					detailParamMapper.insert(param);
				}
			}

			if (null != type.getMinfos() && type.getMinfos().size() > 0) {
				for (RequirInfo info : type.getMinfos()) {
					info.setTypeId(typeId);
					requirInfoMapper.insert(info);
				}
			}
		}
		return typeId;
	}

	@Override
	public List<SpecVal> getSpecvalList(Long specId) {
		SpecValExample example = new SpecValExample();
		SpecValExample.Criteria c = example.createCriteria();
		c.andSpecidEqualTo(specId);
		return specValMapper.selectByExample(example);
	}

	@Override
	public List<Type> getTypeList(Type type, String order, int currPage,
			int pageSize) {
		TypeExample example = new TypeExample();
		TypeExample.Criteria c = example.createCriteria();
		proSearchParam(type, c);
		if (order != null && order.trim().length() > 0) {
			example.setOrderByClause(order);
		}
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return typeMapper.selectPageByExample(example);
	}

	@Override
	public int count(Type type) {
		TypeExample example = new TypeExample();
		TypeExample.Criteria c = example.createCriteria();
		proSearchParam(type, c);
		return typeMapper.countByExample(example);
	}

	@Override
	public Type getType(Long typeId) {
		return typeMapper.selectByPrimaryKey(typeId);
	}

	@Override
	public void UpdateType(Type type) {
		// TODO Auto-generated method stub

	}

	public void proSearchParam(Type type, TypeExample.Criteria c) {
		if (null != type) {
			if (null != type.getId()) {
				c.andIdEqualTo(type.getId());
			}
			if (StringUtils.isNotEmpty(type.getTitle())) {
				c.andTitleLike("'%" + type.getTitle() + "%'");
			}
		}
	}

	@Override
	public Property getProp(Long propid) {
		return propertyMapper.selectByPrimaryKey(propid);
	}

	@Override
	public List<PropsVal> getPropsValList(Long proId) {
		PropsValExample example = new PropsValExample();
		PropsValExample.Criteria c = example.createCriteria();
		c.andProdIdEqualTo(proId);
		List<PropsVal> list = propvalTMapper.selectByExample(example);

		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public PropsVal getPropsVal(Long pvId) {
		return propvalTMapper.selectByPrimaryKey(pvId);
	}

}
