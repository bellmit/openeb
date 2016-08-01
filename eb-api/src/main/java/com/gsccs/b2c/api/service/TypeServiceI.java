package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.PropsVal;
import com.gsccs.eb.api.domain.goods.Specific;

public interface TypeServiceI {

	public PropsVal getPropsVal(Long pvId);
	
	
	public List<Specific> findSpecList(Long typeid);
	
	public List<Property> findPropList(Long typeid);

}
