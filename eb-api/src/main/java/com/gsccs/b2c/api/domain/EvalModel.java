package com.gsccs.b2c.api.domain;

import java.util.List;

/**
 * 评分项目基础对象
 * @author niu x j 
 *
 */
public class EvalModel extends DomainObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 评分项目Id
	 */
	private Long typeid ;
	
	/**
	 * 站点Id
	 */
	private Long siteid;
	
	/**
	 * 评分项目名称
	 */
	private String typename;
	
	/**
	 * 状态
	 */
	private String state;
	
	/**
	 * 是否默认
	 */
	private String isdefault;
	/**
	 * 评分项目包含的打分项列表
	 */
	private List<EvalItem> eiList;
	
	
	public Long getTypeid() {
		return typeid;
	}
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	public Long getSiteid() {
		return siteid;
	}
	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}
	public List<EvalItem> getEiList() {
		return eiList;
	}
	public void setEiList(List<EvalItem> eiList) {
		this.eiList = eiList;
	}
	
	
}
