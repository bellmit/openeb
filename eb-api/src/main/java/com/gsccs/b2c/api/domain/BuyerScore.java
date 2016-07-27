package com.gsccs.b2c.api.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author x.d zhang
 *
 */
public class BuyerScore extends DomainObject {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String orderid;
	private Date addtime;
	private Integer points;
	private String type;
	private Date validity;
	private Long buyerid;
	private String notes;
	
	private String addtimestr;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	public Long getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(Long buyerid) {
		this.buyerid = buyerid;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String getAddtimestr() {
		if (null != getAddtime()){
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			addtimestr = df.format(getAddtime());
		}
		return addtimestr;
	}
	public void setAddtimestr(String addtimestr) {
		this.addtimestr = addtimestr;
	}
	
	
	

}
