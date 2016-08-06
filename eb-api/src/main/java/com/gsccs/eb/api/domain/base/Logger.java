package com.gsccs.eb.api.domain.base;

import java.util.Date;

/**
 * @说明  
 * @开发者 ma hong
 * @年月日 2015年4月10日
 * @时分秒 下午4:17:37
 */
public class Logger {
	
    private Long id;
    private String broswer;		//会员使用的浏览器
    private String logcontent;	//会员操作（登录1，退出2）
    private String ipnote;		//ip记录
    private Date operatetime;	//会员登录或退出时间
    private String accountid;	//会员id
    private String loglevel;	//操作级别（1：登录，2：退出）
    /*===================================================================================*/
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    /*===================================================================================*/
    public String getBroswer() {
        return broswer;
    }
    public void setBroswer(String broswer) {
        this.broswer = broswer == null ? null : broswer.trim();
    }
    /*===================================================================================*/
    public String getLogcontent() {
        return logcontent;
    }
    public void setLogcontent(String logcontent) {
        this.logcontent = logcontent == null ? null : logcontent.trim();
    }
    /*===================================================================================*/
    public String getIpnote() {
        return ipnote;
    }
    public void setIpnote(String ipnote) {
        this.ipnote = ipnote == null ? null : ipnote.trim();
    }
    /*===================================================================================*/
    public Date getOperatetime() {
        return operatetime;
    }
    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }
    /*===================================================================================*/
    public String getAccountid() {
        return accountid;
    }
    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }
    /*===================================================================================*/
    public String getLoglevel() {
        return loglevel;
    }
    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel == null ? null : loglevel.trim();
    }
    /*===================================================================================*/
}