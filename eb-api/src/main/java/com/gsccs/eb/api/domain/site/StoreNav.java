package com.gsccs.eb.api.domain.site;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 店铺导航
 * 
 * @author x.d zhang
 * 
 */
public class StoreNav extends Domain {
	
	private static final long serialVersionUID = 4621223357477477886L;
	
	private String id;
	private String title;
	private String href;
	private String iscate;
	private String blank;
	private String state;
	
	private Long cateid;
	private Long siteid;

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
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getIscate() {
		return iscate;
	}

	public void setIscate(String iscate) {
		this.iscate = iscate;
	}

	public Long getCateid() {
		return cateid;
	}

	public void setCateid(Long cateid) {
		this.cateid = cateid;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getSiteid() {
		return siteid;
	}

	public void setSiteid(Long siteid) {
		this.siteid = siteid;
	}

	

}
