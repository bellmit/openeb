package com.gsccs.b2c.api.domain;

public class Templet extends Domain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String state;

    private Integer ordernum;

    private Long adduser;

    private String img;

    private String description;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Long getAdduser() {
		return adduser;
	}

	public void setAdduser(Long adduser) {
		this.adduser = adduser;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
