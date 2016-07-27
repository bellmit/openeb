package com.gsccs.b2c.api.domain;

import java.util.List;

/**
 * 类目属性
 * 
 * @author x.d zhang
 * 
 */
public class CateProp extends DomainObject {

	private Long id;
	private String title;
	private String memo;
	private String alias;
	private String showType;
	private String showModel;
	private String state;
	private Integer ordernum;
	private List<PropsVal> propsVals;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getShowModel() {
		return showModel;
	}

	public void setShowModel(String showModel) {
		this.showModel = showModel;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public List<PropsVal> getPropsVals() {
		return propsVals;
	}

	public void setPropsVals(List<PropsVal> propsVals) {
		this.propsVals = propsVals;
	}

}
