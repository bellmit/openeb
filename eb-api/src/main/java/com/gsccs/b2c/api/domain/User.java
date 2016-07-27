package com.gsccs.b2c.api.domain;

import java.util.Date;

/**
 * 用户
 * @author x.d zhang
 * 
 */
public class User extends DomainObject {

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
	 * 是否受限制。可选值:limited(受限制),unlimited(不受限)
	 */
	private String autoRepost;

	/**
	 * 用户头像地址
	 */
	private String avatar;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 买家信用
	 */
	private UserCredit buyerCredit;

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
	 * 用户是否是金牌卖家
	 */
	private Boolean isGoldenSeller;

	/**
	 * 是否24小时闪电发货(实物类)
	 */
	private Boolean isLightningConsignment;

	/**
	 * 可上传商品图片数量
	 */
	private Long itemImgNum;

	/**
	 * 单张商品图片最大容量(商品主图大小)。单位:k
	 */
	private Long itemImgSize;

	/**
	 * 最近登陆时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date lastVisit;

	/**
	 * 是否是无名良品用户，true or false
	 */
	private Boolean liangpin;

	/**
	 * 用户当前居住地公开信息。如：location.city获取其中的city数据
	 */
	private Location location;

	/**
	 * 用户昵称
	 */
	private String nick;

	/**
	 * 有无实名认证。可选值:authentication(实名认证),not authentication(没有认证)
	 */
	private String promotedType;

	/**
	 * 可上传属性图片数量
	 */
	private Long propImgNum;

	/**
	 * 单张销售属性图片最大容量（非主图的商品图片和商品属性图片）。单位:k
	 */
	private Long propImgSize;

	/**
	 * 卖家信用
	 */
	private UserCredit sellerCredit;

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

	/**
	 * 用户参与垂直市场类型。shoes表示鞋城垂直市场用户，3C表示3C垂直市场用户。多个类型之间用","分隔。如：一个用户既是3C用户又是鞋城用户，
	 * 那么这个字段返回就是"3C,shoes"。如果用户不是垂直市场用户，此字段返回为""。
	 */
	private String verticalMarket;

	/**
	 * 用户的全站vip信息，可取值如下：c(普通会员),asso_vip(荣誉会员)，vip1,vip2,vip3,vip4,vip5,vip6(
	 * 六个等级的正式vip会员)，共8种取值，其中asso_vip是由vip会员衰退而成，与主站上的vip0对应。
	 */
	private String vipInfo;
	
	private Boolean locked;
	
	//登录帐号名
	private String account;
	private String password;
	private String salt;

	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAutoRepost() {
		return autoRepost;
	}

	public void setAutoRepost(String autoRepost) {
		this.autoRepost = autoRepost;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserCredit getBuyerCredit() {
		return buyerCredit;
	}

	public void setBuyerCredit(UserCredit buyerCredit) {
		this.buyerCredit = buyerCredit;
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

	public Boolean getIsGoldenSeller() {
		return isGoldenSeller;
	}

	public void setIsGoldenSeller(Boolean isGoldenSeller) {
		this.isGoldenSeller = isGoldenSeller;
	}

	public Boolean getIsLightningConsignment() {
		return isLightningConsignment;
	}

	public void setIsLightningConsignment(Boolean isLightningConsignment) {
		this.isLightningConsignment = isLightningConsignment;
	}

	public Long getItemImgNum() {
		return itemImgNum;
	}

	public void setItemImgNum(Long itemImgNum) {
		this.itemImgNum = itemImgNum;
	}

	public Long getItemImgSize() {
		return itemImgSize;
	}

	public void setItemImgSize(Long itemImgSize) {
		this.itemImgSize = itemImgSize;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Boolean getLiangpin() {
		return liangpin;
	}

	public void setLiangpin(Boolean liangpin) {
		this.liangpin = liangpin;
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

	public String getPromotedType() {
		return promotedType;
	}

	public void setPromotedType(String promotedType) {
		this.promotedType = promotedType;
	}

	public Long getPropImgNum() {
		return propImgNum;
	}

	public void setPropImgNum(Long propImgNum) {
		this.propImgNum = propImgNum;
	}

	public Long getPropImgSize() {
		return propImgSize;
	}

	public void setPropImgSize(Long propImgSize) {
		this.propImgSize = propImgSize;
	}

	public UserCredit getSellerCredit() {
		return sellerCredit;
	}

	public void setSellerCredit(UserCredit sellerCredit) {
		this.sellerCredit = sellerCredit;
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

	public String getVerticalMarket() {
		return verticalMarket;
	}

	public void setVerticalMarket(String verticalMarket) {
		this.verticalMarket = verticalMarket;
	}

	public String getVipInfo() {
		return vipInfo;
	}

	public void setVipInfo(String vipInfo) {
		this.vipInfo = vipInfo;
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
	
	
	
}
