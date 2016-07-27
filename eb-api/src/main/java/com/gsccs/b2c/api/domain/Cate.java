package com.gsccs.b2c.api.domain;

import java.util.List;

public class Cate extends Domain {

	private static final long serialVersionUID = -767111557461889171L;
	
	private String id;
	private String title;
	private List<Cate> cates;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Cate> getCates() {
		return cates;
	}
	public void setCates(List<Cate> cates) {
		this.cates = cates;
	}
}
