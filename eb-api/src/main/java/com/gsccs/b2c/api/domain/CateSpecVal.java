package com.gsccs.b2c.api.domain;

/**
 * 类目规格
 * 
 * @author x.d zhang
 * 
 */
public class CateSpecVal extends DomainObject {

	private Long id;
	private String title;
	private String alias;

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
