package com.gsccs.b2c.api.domain;

public class ProvCityAreaStreetDomain extends DomainObject{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private Integer code; 		
    private Integer parentid;	//所属父级id		
    private String name;		//省份-城市-区-街道（名称）	
    private Integer level;		//省份-城市-区-街道（1,2,3,4）

    /*===================================================================================*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    /*===================================================================================*/
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    /*===================================================================================*/
    public Integer getParentid() {
        return parentid;
    }
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    /*===================================================================================*/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /*===================================================================================*/
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    /*===================================================================================*/
	
}
