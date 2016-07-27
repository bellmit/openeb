package com.gsccs.b2c.plat.order.model;

import java.util.Date;

public class ReturnOrderT {
    private Long id;

    private String ordernum;

    private Date createreturngoodstime;

    private String returngoodsreason;

    private String returngoodsstatus;

    private Double price;

    private String returngoodsaddress;

    private Date authreturngoodstime;

    private String authreturngoodsexplain;

    private Date submitreturngoodsformtime;

    private String logisticsnum;

    private Date finishreturngoodstime;

    private String finishreturngoodsexplain;

    private Date createbackmoneytime;

    private String backmoneyreason;

    private String backmoneyexplain;

    private String backmoneystatus;

    private String img;

    private Long productid;

    private Long storeid;

    private String productname;

    private Long bid;

    private String bname;

    private String shipmethod;

    private Double shipfee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Date getCreatereturngoodstime() {
        return createreturngoodstime;
    }

    public void setCreatereturngoodstime(Date createreturngoodstime) {
        this.createreturngoodstime = createreturngoodstime;
    }

    public String getReturngoodsreason() {
        return returngoodsreason;
    }

    public void setReturngoodsreason(String returngoodsreason) {
        this.returngoodsreason = returngoodsreason == null ? null : returngoodsreason.trim();
    }

    public String getReturngoodsstatus() {
        return returngoodsstatus;
    }

    public void setReturngoodsstatus(String returngoodsstatus) {
        this.returngoodsstatus = returngoodsstatus == null ? null : returngoodsstatus.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getReturngoodsaddress() {
        return returngoodsaddress;
    }

    public void setReturngoodsaddress(String returngoodsaddress) {
        this.returngoodsaddress = returngoodsaddress == null ? null : returngoodsaddress.trim();
    }

    public Date getAuthreturngoodstime() {
        return authreturngoodstime;
    }

    public void setAuthreturngoodstime(Date authreturngoodstime) {
        this.authreturngoodstime = authreturngoodstime;
    }

    public String getAuthreturngoodsexplain() {
        return authreturngoodsexplain;
    }

    public void setAuthreturngoodsexplain(String authreturngoodsexplain) {
        this.authreturngoodsexplain = authreturngoodsexplain == null ? null : authreturngoodsexplain.trim();
    }

    public Date getSubmitreturngoodsformtime() {
        return submitreturngoodsformtime;
    }

    public void setSubmitreturngoodsformtime(Date submitreturngoodsformtime) {
        this.submitreturngoodsformtime = submitreturngoodsformtime;
    }

    public String getLogisticsnum() {
        return logisticsnum;
    }

    public void setLogisticsnum(String logisticsnum) {
        this.logisticsnum = logisticsnum == null ? null : logisticsnum.trim();
    }

    public Date getFinishreturngoodstime() {
        return finishreturngoodstime;
    }

    public void setFinishreturngoodstime(Date finishreturngoodstime) {
        this.finishreturngoodstime = finishreturngoodstime;
    }

    public String getFinishreturngoodsexplain() {
        return finishreturngoodsexplain;
    }

    public void setFinishreturngoodsexplain(String finishreturngoodsexplain) {
        this.finishreturngoodsexplain = finishreturngoodsexplain == null ? null : finishreturngoodsexplain.trim();
    }

    public Date getCreatebackmoneytime() {
        return createbackmoneytime;
    }

    public void setCreatebackmoneytime(Date createbackmoneytime) {
        this.createbackmoneytime = createbackmoneytime;
    }

    public String getBackmoneyreason() {
        return backmoneyreason;
    }

    public void setBackmoneyreason(String backmoneyreason) {
        this.backmoneyreason = backmoneyreason == null ? null : backmoneyreason.trim();
    }

    public String getBackmoneyexplain() {
        return backmoneyexplain;
    }

    public void setBackmoneyexplain(String backmoneyexplain) {
        this.backmoneyexplain = backmoneyexplain == null ? null : backmoneyexplain.trim();
    }

    public String getBackmoneystatus() {
        return backmoneystatus;
    }

    public void setBackmoneystatus(String backmoneystatus) {
        this.backmoneystatus = backmoneystatus == null ? null : backmoneystatus.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getStoreid() {
        return storeid;
    }

    public void setStoreid(Long storeid) {
        this.storeid = storeid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getShipmethod() {
        return shipmethod;
    }

    public void setShipmethod(String shipmethod) {
        this.shipmethod = shipmethod == null ? null : shipmethod.trim();
    }

    public Double getShipfee() {
        return shipfee;
    }

    public void setShipfee(Double shipfee) {
        this.shipfee = shipfee;
    }
}