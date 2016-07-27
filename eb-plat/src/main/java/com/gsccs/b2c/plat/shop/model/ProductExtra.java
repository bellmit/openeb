package com.gsccs.b2c.plat.shop.model;

public class ProductExtra {

	private Long id;
	private String propsstr;
	private String reqinfostr;
	private String paramsstr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPropsstr() {
		return propsstr;
	}

	public void setPropsstr(String propsstr) {
		this.propsstr = propsstr == null ? null : propsstr.trim();
	}

	public String getReqinfostr() {
		return reqinfostr;
	}

	public void setReqinfostr(String reqinfostr) {
		this.reqinfostr = reqinfostr == null ? null : reqinfostr.trim();
	}

	public String getParamsstr() {
		return paramsstr;
	}

	public void setParamsstr(String paramsstr) {
		this.paramsstr = paramsstr == null ? null : paramsstr.trim();
	}
}