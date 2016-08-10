package com.gsccs.eb.api.domain.base;

import java.util.Date;

import com.gsccs.b2c.api.domain.Credit;
import com.gsccs.b2c.api.domain.Location;

/**
 * 登录帐号
 * 
 * @author x.d zhang
 * 
 */
public class Account extends Domain {

	private static final long serialVersionUID = 4183136143627688513L;

	/**
	 * 用户数字ID
	 */
	private Long id;
	/**
	 * 站点ID
	 */
	private Long shopid;

	/**
	 * 用户头像地址
	 */
	private String photo;

	/**
	 * 信用
	 */
	private Credit credit;

	/**
	 * 联系人email
	 */
	private String email;

	/**
	 * 注册时间
	 */
	private Date regtime;

	/**
	 * 最近登陆时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date lasttime;

	/**
	 * 用户当前居住地公开信息。如：location.city获取其中的city数据
	 */
	private Location location;

	/**
	 * 用户昵称
	 */
	private String nick;

	/**
	 * 性别。可选值:m(男),f(女)
	 */
	private String sex;

	/**
	 * 状态。可选值:normal(正常),inactive(未激活),delete(删除),reeze(冻结),supervise(监管)
	 */
	private String status;

	/**
	 * 用户类型。可选值:B(B商家),C(C商家)
	 */
	private String type;

	private Boolean locked;

	// 登录帐号名
	private String account;
	private String password;
	private String salt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public String getCredentialsSalt() {
		return "";
	}

}
