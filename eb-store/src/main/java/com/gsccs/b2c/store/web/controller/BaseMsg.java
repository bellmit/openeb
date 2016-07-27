package com.gsccs.b2c.store.web.controller;

public class BaseMsg {
	
	private String code;
	private boolean isok;
	private String msg;
	private Object data;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isIsok() {
		return isok;
	}
	public void setIsok(boolean isok) {
		this.isok = isok;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	
	

}
