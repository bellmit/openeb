package com.gsccs.eb.api.domain.goods;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 规格值
 * 
 * @author x.d zhang
 * 
 */
public class SpecVal extends Domain{

	private Long id;
	private String title;
	private String alias;
	private Integer ordernum;
	private Long specid;
	
	
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
		this.title = title == null ? null : title.trim();
	}

	
	public String getAlias() {
		return alias;
	}

	
	public void setAlias(String alias) {
		this.alias = alias == null ? null : alias.trim();
	}

	
	public Integer getOrdernum() {
		return ordernum;
	}

	
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Long getSpecid() {
		return specid;
	}

	public void setSpecid(Long specid) {
		this.specid = specid;
	}
}