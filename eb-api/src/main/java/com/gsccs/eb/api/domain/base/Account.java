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
	private Long userId;
	/**
	 * 站点ID
	 */
	private Long siteId;

	/**
	 * 用户头像地址
	 */
	private String phone;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 信用
	 */
	private Credit credit;

	/**
	 * 用户注册时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date created;

	/**
	 * 联系人email
	 */
	private String email;

	/**
	 * 用户作为卖家是否开过店
	 */
	private Boolean hasShop;

	/**
	 * 表示用户是否具备修改商品减库存逻辑的权限（一共有拍下减库存和付款减库存两种逻辑） 值含义： 1）true：是 2）false：否。
	 */
	private Boolean hasSubStock;

	/**
	 * 最近登陆时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date lastVisit;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getHasShop() {
		return hasShop;
	}

	public void setHasShop(Boolean hasShop) {
		this.hasShop = hasShop;
	}

	public Boolean getHasSubStock() {
		return hasSubStock;
	}

	public void setHasSubStock(Boolean hasSubStock) {
		this.hasSubStock = hasSubStock;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
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

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
