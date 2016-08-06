package com.gsccs.b2c.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gsccs.b2c.plat.shop.service.GoodsService;
import com.gsccs.b2c.plat.shop.service.TypeService;
import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.PropsVal;
import com.gsccs.eb.api.domain.goods.Specific;


public class TypeServiceAPI implements TypeServiceI {

	@Autowired
	private TypeService typeService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Override
	public List<Specific> findSpecList(Long typeId) {
		List<Specific> specList = typeService.getSpecByTypeId(typeId);
		return specList;
	}

	@Override
	public List<Property> findPropList(Long typeId) {
		List<Property> propList = typeService.getPropList(typeId);
		return propList;
	}


	@Override
	public PropsVal getPropsVal(Long pvId) {
		PropsVal pv = typeService.getPropsVal(pvId);
		return pv;
	}

}
