package com.gsccs.eb.api.domain.goods;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 产品扩展信息
 * 
 * @author x.d zhang
 * 
 */
public class ProductParam extends Domain {

	private static final long serialVersionUID = 2374511556384662169L;

	/**
	 * 参数组ID
	 */
	private Long groupId;

	/**
	 * 参数组名称
	 */
	private String groupName;

	/**
	 * 参数ID
	 */
	private Long paramId;

	/**
	 * 参数名称
	 */
	private String paramName;

	/**
	 * 参数值
	 */
	private String paramVal;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getParamId() {
		return paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamVal() {
		return paramVal;
	}

	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}

	/**
	 * 产品属性参数。结构:"参数组1:参数1:参数值1;参数2:参数值2;…… 参数组2:参数1:参数值1;参数2:参数值2;……"
	 * 所有属性别名加起来不能超过 3999字节。
	 */
	public String getParamStr() {
		return this.groupId + ":" + this.getGroupName() + ":"
				+ this.getParamId();
	}
}
