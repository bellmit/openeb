package com.gsccs.eb.api.domain.buyer;

import com.gsccs.eb.api.domain.base.Domain;

/**
 * 会员等级
 * 
 * @author x.d zhang
 * 
 */
public class Grade extends Domain {

	private static final long serialVersionUID = 3897573635852722321L;

	private Long id;
	private String name;
	private Integer experience;
	private String isdefault;
	private Integer point;
	private Float disCount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Float getDisCount() {
		return disCount;
	}

	public void setDisCount(Float disCount) {
		this.disCount = disCount;
	}

}
