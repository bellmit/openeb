package com.gsccs.eb.api.domain.rated;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 评分项目
 * @author niu x j
 *
 */
public class EvalType extends Domain{
	
	
	private Long id;
    private String title;
    private String state;
    private Long siteid;
    private String isdefault;

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
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault == null ? null : isdefault.trim();
    }
}