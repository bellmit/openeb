package com.gsccs.eb.api.domain.goods;

import java.util.Date;
import java.util.List;

import com.gsccs.b2c.api.domain.Domain;
import com.gsccs.b2c.api.domain.PropImg;
import com.gsccs.eb.api.domain.site.Video;

/**
 * 产品结构
 * 
 * @author x.d zhang
 * 
 */
public class Product extends Domain {

	private static final long serialVersionUID = 7214112869815458438L;

	private Long id;
	/**
	 * 产品ID
	 */
	private Long pId;

	/**
	 * 产品条码信息
	 */
	private String barcode;

	/**
	 * 品牌ID
	 */
	private Long brand;

	/**
	 * 站点id
	 */
	private Long site;

	/**
	 * 品牌Name
	 */
	private String brandName;

	/**
	 * 产品的非关键属性列表.格式:pid:vid;pid:vid.
	 */
	private String binds;

	/**
	 * 产品的非关键属性字符串列表.格式同props_str(<strong>注：</strong><font
	 * color="red">属性名称中的冒号":"被转换为："#cln#"; 分号";"被转换为："#scln#" </font>)
	 */
	private String bindsStr;

	/**
	 * 产品关键词，用于筛选商品，多个关键词用半角竖线"|"分开
	 */
	private String keyWords;

	/**
	 * 商品类目名称
	 */
	private String cateName;

	/**
	 * 商品类目ID
	 */
	private String cateId;

	/**
	 * 产品的collect次数（不提供数据，返回0)
	 */
	private Long collectNum;

	/**
	 * 品类ID
	 */
	private Long typeId;

	/**
	 * 创建时间.格式:yyyy-mm-dd hh:mm:ss
	 */
	private Date created;

	private String createdStr;

	/**
	 * 产品的描述.最大25000个字节
	 */
	private String desc;

	/**
	 * 标识套装产品是否有效，无效的套装产品需要重新发布
	 */
	private Boolean isSuiteEffective;

	/**
	 * 产品的级别level
	 */
	private Long level;

	/**
	 * 修改时间.格式:yyyy-mm-dd hh:mm:ss
	 */
	private Date modified;

	private String modifiedStr;

	/**
	 * 产品名称
	 */
	private String title;

	/**
	 * 产品的主图片地址.(绝对地址,格式:http://host/image_path)
	 */
	private String picUrl;

	/**
	 * 产品的销售价.单位为元.精确到2位小数;如:200.07
	 */
	private Double price;

	/**
	 * 产品的市场价格
	 */
	private Double marketPrice;

	/**
	 * 产品的成本价
	 */
	private Double cost;

	/**
	 * 产品的子图片.目前最多支持4张。fields中设置为product_imgs.id、product_imgs.url、product_imgs.
	 * position 等形式就会返回相应的字段
	 */
	private List<Attach> productImgs;

	/**
	 * 产品的属性图片.比如说黄色对应的产品图片,绿色对应的产品图片。fields中设置为product_prop_imgs.id、
	 * product_prop_imgs
	 * .props、product_prop_imgs.url、product_prop_imgs.position等形式就会返回相应的字段
	 */
	private List<PropImg> productPropImgs;

	/**
	 * 产品的评分次数
	 */
	private Long rateNum;

	/**
	 * 产品的销售量
	 */
	private Integer saleNum;

	/**
	 * 商品上传后的状态。onsale出售中，instock库中 是否立即上架(1是立即上架。表示在库存中。) <li>产品在出售中：status=1</li>
	 * <li>产品在库存中：status=0</li> <li>产品违规下架：status=2</li>
	 * 宝贝有三种情况（仓库中[等待上架和违规下架]，出售中，预警中[库存数量小于店铺设置预警数量stockAlertNum]）
	 */
	private String status;

	/**
	 * 库存量
	 */
	private Integer storenum;

	/**
	 * 评价数量
	 */
	private Integer evalnum;

	/**
	 * 库存预警值(在plat_store表中)
	 */
	private Integer stockalertnum;

	/**
	 * 模板ID
	 */
	private Long templateId;

	/**
	 * 标准产品编码
	 */
	private String tsc;

	/**
	 * 产品简介
	 */
	private String brief;

	/**
	 * 支持会员打折,true/false
	 */
	private Boolean hasDiscount;

	/**
	 * 是否有发票,true/false
	 */
	private Boolean hasInvoice;

	/**
	 * 是否有保修,true/false
	 */
	private Boolean hasWarranty;

	/**
	 * 是否24小时闪电发货
	 */
	private Boolean isLightningConsignment;

	/**
	 * 是否定时上架商品
	 */
	private Boolean isTiming;

	/**
	 * 虚拟商品的状态字段
	 */
	private Boolean isVirtual;

	/**
	 * 标示商品是否为新品。 值含义：true-是，false-否。
	 */
	private Boolean isXinpin;

	private Boolean isTop;
	private Boolean isHot;

	/**
	 * 宝贝所属的运费模板ID，如果没有返回则说明没有使用运费模板
	 */
	private String postage;

	/**
	 * 消保类型，多个类型以,分割。可取以下值： 2：假一赔三；4：7天无理由退换货；
	 */
	private String promotedService;

	/**
	 * 下架时间（格式：yyyy-MM-dd HH:mm:ss）
	 */
	private Date delistTime;

	/**
	 * ems费用,格式：5.00；单位：元；精确到：分
	 */
	private String emsFee;

	/**
	 * 快递费用,格式：5.00；单位：元；精确到：分
	 */
	private String expressFee;

	/**
	 * （过时）
	 * 
	 * 
	 */
	private String approveStatus;

	/**
	 * 商品上传后的状态显示值
	 */
	private String approveStatusStr;

	/**
	 * 商品的积分返点比例。如:5,表示:返点比例0.5%
	 */
	private float auctionPoint;

	/**
	 * 表示商品的体积，用于按体积计费的运费模板。该值的单位为立方米（m3）。
	 * 该值支持两种格式的设置：格式1：bulk:3,单位为立方米(m3),表示直接设置为商品的体积
	 * 。格式2：weight:10;breadth:10;height:10，单位为米（m）
	 */
	private String itemSize;

	/**
	 * 商品的重量，用于按重量计费的运费模板。注意：单位为kg
	 */
	private Integer weight;

	/**
	 * 商品属性图片列表。fields中只设置prop_img可以返回PropImg结构体中所有字段，如果设置为prop_img.id、prop_img.
	 * url、prop_img.properties、prop_img.position等形式就只会返回相应的字段
	 */
	private List<PropImg> propImgs;

	/**
	 * 商品视频列表(目前只支持单个视频关联)。fields中只设置video可以返回Video结构体中所有字段，如果设置为video.id、video.
	 * video_id、 video.url等形式就只会返回相应的字段
	 */
	private List<Video> videos;

	/**
	 * 有效期,7或者14（默认是7天）
	 */
	private Long validThru;

	/**
	 * 预扣库存，即付款减库存的商品现在有多少处于未付款状态的订单
	 */
	private Integer locknum;

	/**
	 * 商品销量
	 */
	private Integer salenum;

	/**
	 * 产品扩展属性。标识着props内容里面的pid、属性名称、属性值对应关系。格式为：pid1:pid1_name1:vid_value;pid2:
	 * pid_name:vid_value……
	 */
	private List<ProductProp> props;

	/**
	 * 产品参数属性。
	 */
	private List<ProductParam> params;
	/**
	 * 购物必填信息
	 */
	private List<ProductReqInfo> reqInfos;

	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBinds() {
		return binds;
	}

	public void setBinds(String binds) {
		this.binds = binds;
	}

	public String getBindsStr() {
		return bindsStr;
	}

	public void setBindsStr(String bindsStr) {
		this.bindsStr = bindsStr;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public Long getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(Long collectNum) {
		this.collectNum = collectNum;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getIsSuiteEffective() {
		return isSuiteEffective;
	}

	public void setIsSuiteEffective(Boolean isSuiteEffective) {
		this.isSuiteEffective = isSuiteEffective;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Attach> getProductImgs() {
		return productImgs;
	}

	public void setProductImgs(List<Attach> productImgs) {
		this.productImgs = productImgs;
	}

	public List<PropImg> getProductPropImgs() {
		return productPropImgs;
	}

	public void setProductPropImgs(List<PropImg> productPropImgs) {
		this.productPropImgs = productPropImgs;
	}

	public Long getRateNum() {
		return rateNum;
	}

	public void setRateNum(Long rateNum) {
		this.rateNum = rateNum;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTsc() {
		return tsc;
	}

	public void setTsc(String tsc) {
		this.tsc = tsc;
	}

	public String getPostage() {
		return postage;
	}

	public void setPostage(String postage) {
		this.postage = postage;
	}

	public List<ProductProp> getProps() {
		return props;
	}

	public void setProps(List<ProductProp> props) {
		this.props = props;
	}

	public List<ProductParam> getParams() {
		return params;
	}

	public void setParams(List<ProductParam> params) {
		this.params = params;
	}

	public List<ProductReqInfo> getReqInfos() {
		return reqInfos;
	}

	public void setReqInfos(List<ProductReqInfo> reqInfos) {
		this.reqInfos = reqInfos;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Boolean getHasDiscount() {
		return hasDiscount;
	}

	public void setHasDiscount(Boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}

	public Boolean getHasInvoice() {
		return hasInvoice;
	}

	public void setHasInvoice(Boolean hasInvoice) {
		this.hasInvoice = hasInvoice;
	}

	public Boolean getHasWarranty() {
		return hasWarranty;
	}

	public void setHasWarranty(Boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}

	public Boolean getIsLightningConsignment() {
		return isLightningConsignment;
	}

	public void setIsLightningConsignment(Boolean isLightningConsignment) {
		this.isLightningConsignment = isLightningConsignment;
	}

	public Boolean getIsTiming() {
		return isTiming;
	}

	public void setIsTiming(Boolean isTiming) {
		this.isTiming = isTiming;
	}

	public Boolean getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(Boolean isVirtual) {
		this.isVirtual = isVirtual;
	}

	public Boolean getIsXinpin() {
		return isXinpin;
	}

	public void setIsXinpin(Boolean isXinpin) {
		this.isXinpin = isXinpin;
	}

	public String getPromotedService() {
		return promotedService;
	}

	public void setPromotedService(String promotedService) {
		this.promotedService = promotedService;
	}

	public Date getDelistTime() {
		return delistTime;
	}

	public void setDelistTime(Date delistTime) {
		this.delistTime = delistTime;
	}

	public String getEmsFee() {
		return emsFee;
	}

	public void setEmsFee(String emsFee) {
		this.emsFee = emsFee;
	}

	public String getExpressFee() {
		return expressFee;
	}

	public void setExpressFee(String expressFee) {
		this.expressFee = expressFee;
	}

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public float getAuctionPoint() {
		return auctionPoint;
	}

	public void setAuctionPoint(float auctionPoint) {
		this.auctionPoint = auctionPoint;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<PropImg> getPropImgs() {
		return propImgs;
	}

	public void setPropImgs(List<PropImg> propImgs) {
		this.propImgs = propImgs;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Long getValidThru() {
		return validThru;
	}

	public void setValidThru(Long validThru) {
		this.validThru = validThru;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public Integer getSalenum() {
		return salenum;
	}

	public void setSalenum(Integer salenum) {
		this.salenum = salenum;
	}

	public Integer getStorenum() {
		return storenum;
	}

	public void setStorenum(Integer storenum) {
		this.storenum = storenum;
	}

	public Integer getStockalertnum() {
		return stockalertnum;
	}

	public void setStockalertnum(Integer stockalertnum) {
		this.stockalertnum = stockalertnum;
	}

	public String getApproveStatusStr() {
		return approveStatusStr;
	}

	public void setApproveStatusStr(String approveStatusStr) {
		this.approveStatusStr = approveStatusStr;
	}

	public String getCreatedStr() {
		if (created != null) {
			createdStr = com.gsccs.eb.api.utils.DateUtil.format(created,
					"yyyy-MM-dd");
		}
		return createdStr;
	}

	public void setCreatedStr(String createdStr) {
		this.createdStr = createdStr;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsTop() {
		return isTop;
	}

	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getSite() {
		return site;
	}

	public void setSite(Long site) {
		this.site = site;
	}

	public String getModifiedStr() {
		if (modified != null) {
			modifiedStr = com.gsccs.eb.api.utils.DateUtil.format(modified,
					"yyyy-MM-dd");
		}
		return modifiedStr;
	}

	public void setModifiedStr(String modifiedStr) {
		this.modifiedStr = modifiedStr;
	}

	public Integer getEvalnum() {
		return evalnum;
	}

	public void setEvalnum(Integer evalnum) {
		this.evalnum = evalnum;
	}
}
