package com.gsccs.b2c.api.domain;

/**
 * 物流公司基础数据结构
 * @author x.d zhang
 *
 */
public class DlyCorp extends DomainObject {
	
	private static final long serialVersionUID = 4669391435331949667L;
	private Integer id;
    private String name;
    private String code;
    private String website;
    private Integer sort;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }


}
