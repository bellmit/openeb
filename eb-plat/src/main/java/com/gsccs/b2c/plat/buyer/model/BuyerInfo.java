package com.gsccs.b2c.plat.buyer.model;

import java.util.Date;
/**
 * @说明   会员资料---基本信息
 * @开发者 ma hong
 * @年月日 2015年4月8日
 * @时分秒 上午10:01:13
 */
public class BuyerInfo {
	
    private Long id;
    private String nickName;    	//会员昵称
    private String sex;				//会员性别	
    private Date birthday;			//出生年月
    private String domicile;		//居住地
    private String constellation;	//星座
    private String headphoto;		//会员头像
    private String phonenumber;		//移动电话
    private String email;			//邮箱地址
    private String identitycard;	//身份证号

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    /*===================================================================================*/
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    /*===================================================================================*/
    public String getDomicile() {
        return domicile;
    }
    public void setDomicile(String domicile) {
        this.domicile = domicile == null ? null : domicile.trim();
    }
    /*===================================================================================*/
    public String getConstellation() {
        return constellation;
    }
    public void setConstellation(String constellation) {
        this.constellation = constellation == null ? null : constellation.trim();
    }
    /*===================================================================================*/
    public String getHeadphoto() {
        return headphoto;
    }
    public void setHeadphoto(String headphoto) {
        this.headphoto = headphoto == null ? null : headphoto.trim();
    }
    /*===================================================================================*/
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
    /*===================================================================================*/
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    /*===================================================================================*/
    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard == null ? null : identitycard.trim();
    }
    /*===================================================================================*/
	@Override
	public String toString() {
		return "BuyerAccountInfo [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", domicile="
				+ domicile + ", constellation=" + constellation + ", headphoto=" + headphoto + ", phonenumber=" + phonenumber
				+ ", email=" + email + ", identitycard=" + identitycard + "]";
	}
    
    
}