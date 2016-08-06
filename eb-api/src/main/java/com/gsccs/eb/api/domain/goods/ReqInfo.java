package com.gsccs.eb.api.domain.goods;

import com.gsccs.eb.api.domain.base.Domain;

public class ReqInfo extends Domain {
	
	private static final long serialVersionUID = 2374511556384662169L;

	/**
	 * 产品购物必填参数ID
	 */
	private Long fieldId;

	/**
	 * 产品购物必填参数名称
	 */
	private String fieldName;

	/**
	 * 产品购物必填参数信息
	 */
	private String fieldValue;

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getReqInfoStr() {
		return this.getFieldId() + ":" + this.getFieldName() + ":"
				+ this.getFieldValue();
	}
}
