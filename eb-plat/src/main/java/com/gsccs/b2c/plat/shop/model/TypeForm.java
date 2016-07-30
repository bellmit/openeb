package com.gsccs.b2c.plat.shop.model;

import java.util.List;

import com.gsccs.eb.api.domain.goods.Property;
import com.gsccs.eb.api.domain.goods.Specific;
import com.gsccs.eb.api.domain.goods.Type;

public class TypeForm {

	private Type goodsType;
	private List<Specific> specList;
	private List<Property> attrList;

	public Type getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Type goodsType) {
		this.goodsType = goodsType;
	}

	public List<Specific> getSpecList() {
		return specList;
	}

	public void setSpecList(List<Specific> specList) {
		this.specList = specList;
	}

	public List<Property> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<Property> attrList) {
		this.attrList = attrList;
	}

}
