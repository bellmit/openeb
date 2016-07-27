package com.gsccs.eb.api.domain.deliver;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 物流公司基础数据结构
 * @author x.d zhang
 *
 */
public class DlyType extends Domain {
	
	/*private static final long serialVersionUID = 4669391435331949667L;

	*//**
	 * 物流公司代码
	 *//*
	private String code;

	*//**
	 * 物流公司标识
	 *//*
	private Long id;

	*//**
	 * 物流公司简称
	 *//*
	private String name;

	*//**
	 * 运单号验证正则表达式
	 *//*
	private String regMailNo;*/
	
	////////////////////////////////////////////////////////////////////////////////////
	private Integer id;
    private String name;
    private String code;
    private String website;
    private Integer sort;
    /*===================================================================================*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    /*===================================================================================*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /*===================================================================================*/
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    /*===================================================================================*/
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }
    /*===================================================================================*/
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    /*===================================================================================*/


}
