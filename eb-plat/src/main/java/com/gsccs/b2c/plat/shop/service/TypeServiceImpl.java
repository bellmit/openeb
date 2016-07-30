package com.gsccs.b2c.plat.shop.service;

import java.util.ArrayList;
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
import com.gsccs.b2c.plat.shop.model.TypeSpecExample;
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
	public List<Specific> getSpecByTypeId(Long typeId) {
		return specificMapper.selectByTypeid(typeId);
	}

	@Override
	public List<Property> getPropList(Long typeId) {
		PropertyExample example = new PropertyExample();
		PropertyExample.Criteria c = example.createCriteria();
		c.andTypeIdEqualTo(typeId);
		return propertyMapper.selectByExample(example);
	}


	@Override
	public Long addType(Type type) {
		Long typeId = null;
		if (null != type) {
			typeMapper.insert(type);
			typeId = type.getId();
			//保存类型属性关系
			if (null != type.getProps() && type.getProps().size() > 0) {
				for (Property prop : type.getProps()) {
					prop.setTypeId(typeId);
					propertyMapper.insert(prop);
				}
			}
			//保存类型规格关系
			if (null != type.getSpecs() && type.getSpecs().size() > 0) {
				TypeSpec ts;
				for (Specific spec : type.getSpecs()) {
					ts = new TypeSpec();
					ts.setTypeId(typeId);
					ts.setSpecId(spec.getId());
					typeSpecMapper.insert(ts);
				}
			}
		}
		return typeId;
	}

	
	@Override
	public void updateType(Type type) {
		if (null != type) {
			Long typeId = type.getId();
			//更新类型
			typeMapper.updateByPrimaryKey(type);
			//删除类型规格关系
			this.deleteSpecByTypeId(typeId);
			//更新类型规格关系
			if (null != type.getSpecs() && type.getSpecs().size() > 0) {
				TypeSpec ts;
				for (Specific spec : type.getSpecs()) {
					ts = new TypeSpec();
					ts.setTypeId(typeId);
					ts.setSpecId(spec.getId());
					typeSpecMapper.insert(ts);
				}
			}
			
			//更新类型属性
			if (null != type.getProps() && type.getProps().size() > 0) {
				List<Long> propids = new ArrayList<Long>();
				for (Property prop : type.getProps()) {
					prop.setTypeId(typeId);
					if(null!=prop.getId()){
						propertyMapper.updateByPrimaryKey(prop);
					}else{
						propertyMapper.insert(prop);
					}
					propids.add(prop.getId());
				}
				
				//删除失效属性
				PropertyExample example = new PropertyExample();
				PropertyExample.Criteria c = example.createCriteria();
				c.andTypeIdEqualTo(typeId);
				c.andIdNotIn(propids);
				propertyMapper.deleteByExample(example);
			}
		}
	}
	
	private void deleteSpecByTypeId(Long typeid){
		if (null==typeid){
			return;
		}
		TypeSpecExample example = new TypeSpecExample();
		TypeSpecExample.Criteria c= example.createCriteria();
		c.andTypeIdEqualTo(typeid);
		typeSpecMapper.deleteByExample(example);
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
		Type type = typeMapper.selectByPrimaryKey(typeId);
		if (null != type){
			//规格
			List<Specific> specList = specificMapper.selectByTypeid(typeId);
			if(null != specList && !specList.isEmpty()){
				for(Specific spec:specList){
					List<SpecVal> specVals = specValMapper.selectBySpecid(spec.getId());
					spec.setSpecVals(specVals);
				}
			}
			type.setSpecs(specList);
			//属性
			List<Property> propList = this.getPropList(typeId);
			type.setProps(propList);
		}
		return type;
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

	@Override
	public List<Type> queryByTypeName(String typename) {
		if (StringUtils.isEmpty(typename)) {
			return null;
		} else {
			TypeExample example = new TypeExample();
			TypeExample.Criteria c = example.createCriteria();
			c.andTitleEqualTo(typename);
			example.setCurrPage(1);
			example.setPageSize(Integer.MAX_VALUE);
			return typeMapper.selectPageByExample(example);
		}
	}
	
	
	public void proSearchParam(Type type, TypeExample.Criteria c) {
		if (null != type) {
			if (StringUtils.isNotEmpty(type.getTitle())) {
				c.andTitleLike("'%" + type.getTitle() + "%'");
			}
		}
	}

	@Override
	public void deletePropById(Long propid) {
		propertyMapper.deleteByPrimaryKey(propid);
	}
	
	public void deletePropByTypeId(Long typeId) {
		if(typeId==null){
			return;
		}
		PropertyExample example = new PropertyExample();
		PropertyExample.Criteria c = example.createCriteria();
		c.andTypeIdEqualTo(typeId);
		propertyMapper.deleteByExample(example);
	}

	@Override
	public void deleteTypeById(Long typeId) {
		//删除类型规格关系
		this.deleteSpecByTypeId(typeId);
		//删除类型属性
		this.deletePropByTypeId(typeId);
		//删除类型
		typeMapper.deleteByPrimaryKey(typeId);
	}


}
