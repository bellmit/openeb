package com.gsccs.b2c.plat.buyer.model;

import java.util.Date;
/**
 * @说明   会员登录用户表
 * @开发者 ma hong
 * @年月日 2015年3月30日
 * @时分秒 下午5:12:37
 */
public class BuyerAccount {
	
    private Long id;  
    private String account;		//会员账户
    private String pwd;		    //会员密码
    private String nick;		//会员名称
    private Date addtime;		//会员注册时间
    private Date lasttime;		//会员登录时间
    private String state;		//会员账户状态
    private String islock;		//会员账户状态    （是否被锁定）
    private String salt;		//会员账号密码盐加密
    
    public String getCredentialsSalt() {
		return account + salt;
	}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
    
    public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
    public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	/*===================================================================================*/
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    /*===================================================================================*/
    public String getIslock() {
        return islock;
    }
    public void setIslock(String islock) {
        this.islock = islock == null ? null : islock.trim();
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
   
    
    
}