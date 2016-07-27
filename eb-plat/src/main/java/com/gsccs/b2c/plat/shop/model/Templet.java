package com.gsccs.b2c.plat.shop.model;
/**
 * 平台模板对象
 * @创建人：x.j  niu 
 * @类名称：Templet
 * @创建时间：2015年4月8日 下午4:39:21
 */
public class Templet {
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
        this.name = name == null ? null : name.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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
        this.img = img == null ? null : img.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}