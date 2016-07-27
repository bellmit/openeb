package com.gsccs.b2c.plat.shop.model;
/**
 * 店铺模板配置信息对象
 * @创建人：x.j  niu 
 * @类名称：StoreTemplet
 * @创建时间：2015年4月8日 下午4:39:38
 */
public class StoreTemplet {
    private Long id;

    private Long storeid;

    private Long templetid;

    private String key;

    private String usepage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public Long getTempletid() {
        return templetid;
    }

    public void setTempletid(Long templetid) {
        this.templetid = templetid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getUsepage() {
        return usepage;
    }

    public void setUsepage(String usepage) {
        this.usepage = usepage == null ? null : usepage.trim();
    }
}