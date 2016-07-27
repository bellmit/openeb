package com.gsccs.b2c.plat.site.model;

/**
 * @说明  物流公司
 * @开发者 ma hong
 * @年月日 2015年4月23日
 * @时分秒 上午9:25:15
 */
public class DeliverCorpT {
	
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