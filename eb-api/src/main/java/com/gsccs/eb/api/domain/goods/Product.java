package com.gsccs.eb.api.domain.goods;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;

public class Product extends Domain{

	private Long id;
	private Long shopid;
	private Long brandid;
	private Long categoryid;
	private Long typeid;
	private String cateids;
	private String title;
	private String img;
	private String templet;
	private String ishot;
	private String istop;
	
	private String adduser;
	private String status;
	private String kind;
	private String tags;
	private String barcode;
	private String remark;
	private Double price;
	private Double mkprice;
	// 重量
	private Integer weight;
	// 商品单位
	private String unit;
	private String freight;
	// 快递方式
	private String postage;
	// 积分
	private Float points;
	// 库存量
	private Integer storenum;
	// 销量
	private Integer salenum;
	// 锁定商品数量
	private Integer locknum;
	// 评价次数
	private Integer evalnum;
	// 扩展属性字符串
	private String propStr;
	// 购物必填信息
	private String reqInfoStr;
	// 购物参数属性字符串
	private String paramStr;

	// 商品上架后状态
	private String approvestatus;
	private String keyWords;
	
	private Date addtime;
	private Date topendtime;
	private Integer clicknum;
	
	// 商品URL
	private String url;
	private String content;
	
	
	private String shoptitle;
	private String catetitle;
	private String brandtitle;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}

	public String getTemplet() {
		return templet;
	}

	public void setTemplet(String templet) {
		this.templet = templet == null ? null : templet.trim();
	}

	public String getIshot() {
		return ishot;
	}

	public void setIshot(String ishot) {
		this.ishot = ishot == null ? null : ishot.trim();
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop == null ? null : istop.trim();
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getTopendtime() {
		return topendtime;
	}

	public void setTopendtime(Date topendtime) {
		this.topendtime = topendtime;
	}

	public Integer getClicknum() {
		return clicknum;
	}

	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}

	public String getAdduser() {
		return adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser == null ? null : adduser.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind == null ? null : kind.trim();
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode == null ? null : barcode.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMkprice() {
		return mkprice;
	}

	public void setMkprice(Double mkprice) {
		this.mkprice = mkprice;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getStorenum() {
		return storenum;
	}

	public void setStorenum(Integer storenum) {
		this.storenum = storenum;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight == null ? null : freight.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public String getPropStr() {
		return propStr;
	}

	public void setPropStr(String propStr) {
		this.propStr = propStr;
	}

	public String getReqInfoStr() {
		return reqInfoStr;
	}

	public void setReqInfoStr(String reqInfoStr) {
		this.reqInfoStr = reqInfoStr;
	}

	public String getParamStr() {
		return paramStr;
	}

	public void setParamStr(String paramStr) {
		this.paramStr = paramStr;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getPostage() {
		return postage;
	}

	public void setPostage(String postage) {
		this.postage = postage;
	}

	public String getApprovestatus() {
		return approvestatus;
	}

	public void setApprovestatus(String approvestatus) {
		this.approvestatus = approvestatus;
	}

	public String getCateids() {
		return cateids;
	}

	public void setCateids(String cateids) {
		this.cateids = cateids;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public Long getShopid() {
		return shopid;
	}

	public void setShopid(Long shopid) {
		this.shopid = shopid;
	}

	public Long getBrandid() {
		return brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public Float getPoints() {
		return points;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public Integer getEvalnum() {
		return evalnum;
	}

	public void setEvalnum(Integer evalnum) {
		this.evalnum = evalnum;
	}

	public String getShoptitle() {
		return shoptitle;
	}

	public void setShoptitle(String shoptitle) {
		this.shoptitle = shoptitle;
	}

	public String getCatetitle() {
		return catetitle;
	}

	public void setCatetitle(String catetitle) {
		this.catetitle = catetitle;
	}

	public String getBrandtitle() {
		return brandtitle;
	}

	public void setBrandtitle(String brandtitle) {
		this.brandtitle = brandtitle;
	}
	
	
}