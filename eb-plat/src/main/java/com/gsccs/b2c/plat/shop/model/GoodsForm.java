package com.gsccs.b2c.plat.shop.model;

import java.util.Date;

public class GoodsForm {

	private String id;
	private String title;
	private String subtitle;
	private Long cateid;
	private String cateName;
	private Long brandid;
	private String brandName;
	private Long typeid;
	private String specOpen;
	private String specName;
	private Double price;
	private String priceInterval;
	private String serial;
	private String isonsale;	//商品上架1上架0下架
	private String prepareUp;		//上架时间
	private String iscommend;	//商品推荐
	private String keywords;	//商品关键字
	private String descript;	//商品描述 
	private String goodsBody;
	private String goodsAttr;
	private String goodsSpec;
	private String goodsForm;
	private String goodsColImg;
	private String transportId;	//运费模板ID，不使用运费模板值为0
	private Integer cityId;
	private String cityName;
	private Integer provinceId;
	private String provinceName;
	private String shiptype; // 商品运费承担方式 默认 0为买家承担 1为卖家承担
	private String specJson; // goodsSpec的实体类json串
	private Integer totalStore; // 总库存
	private Double mketPrice; // 市场价
	private Double costPrice; // 成本价
	private String isHaveSpec;

	private String mainImage;
	private String moreImage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Long getCateid() {
		return cateid;
	}

	public void setCateid(Long cateid) {
		this.cateid = cateid;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Long getBrandid() {
		return brandid;
	}

	public void setBrandid(Long brandid) {
		this.brandid = brandid;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getSpecOpen() {
		return specOpen;
	}

	public void setSpecOpen(String specOpen) {
		this.specOpen = specOpen;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPriceInterval() {
		return priceInterval;
	}

	public void setPriceInterval(String priceInterval) {
		this.priceInterval = priceInterval;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getIsonsale() {
		return isonsale;
	}

	public void setIsonsale(String isonsale) {
		this.isonsale = isonsale;
	}

	public String getPrepareUp() {
		return prepareUp;
	}

	public void setPrepareUp(String prepareUp) {
		this.prepareUp = prepareUp;
	}

	public String getIscommend() {
		return iscommend;
	}

	public void setIscommend(String iscommend) {
		this.iscommend = iscommend;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getGoodsBody() {
		return goodsBody;
	}

	public void setGoodsBody(String goodsBody) {
		this.goodsBody = goodsBody;
	}

	public String getGoodsAttr() {
		return goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public String getGoodsForm() {
		return goodsForm;
	}

	public void setGoodsForm(String goodsForm) {
		this.goodsForm = goodsForm;
	}

	public String getGoodsColImg() {
		return goodsColImg;
	}

	public void setGoodsColImg(String goodsColImg) {
		this.goodsColImg = goodsColImg;
	}

	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getShiptype() {
		return shiptype;
	}

	public void setShiptype(String shiptype) {
		this.shiptype = shiptype;
	}

	public String getSpecJson() {
		return specJson;
	}

	public void setSpecJson(String specJson) {
		this.specJson = specJson;
	}

	public Integer getTotalStore() {
		return totalStore;
	}

	public void setTotalStore(Integer totalStore) {
		this.totalStore = totalStore;
	}

	public Double getMketPrice() {
		return mketPrice;
	}

	public void setMketPrice(Double mketPrice) {
		this.mketPrice = mketPrice;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public String getIsHaveSpec() {
		return isHaveSpec;
	}

	public void setIsHaveSpec(String isHaveSpec) {
		this.isHaveSpec = isHaveSpec;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getMoreImage() {
		return moreImage;
	}

	public void setMoreImage(String moreImage) {
		this.moreImage = moreImage;
	}

}
