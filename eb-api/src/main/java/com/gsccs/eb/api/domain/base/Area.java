package com.gsccs.eb.api.domain.base;

/**
 * 地址区域结构
 * 
 * @author x.d zhang
 * 
 */
public class Area extends Domain {

	private static final long serialVersionUID = 1395552857334564623L;

	private Integer id;
	private Integer code;
	private Integer pcode;
	private String name;
	private Integer level;
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getPcode() {
		return pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
