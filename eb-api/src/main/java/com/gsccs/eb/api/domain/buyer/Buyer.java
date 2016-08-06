package com.gsccs.eb.api.domain.buyer;

import java.util.Date;

/**
 * @说明 会员资料---基本信息
 * @开发者 ma hong
 * @年月日 2015年4月8日
 * @时分秒 上午10:01:13
 */
public class Buyer {

	private Long id;
	private String nick; // 会员昵称
	private String sex; // 会员性别
	private Date birthday; // 出生年月
	private String domicile; // 居住地
	private String constellation; // 星座
	private String photo; // 会员头像
	private String phone; // 移动电话
	private String email; // 邮箱地址
	private String idcode; // 身份证号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public String getConstellation() {
		return constellation;
	}

	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

}