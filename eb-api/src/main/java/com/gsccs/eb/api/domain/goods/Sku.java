package com.gsccs.eb.api.domain.goods;

import com.gsccs.b2c.api.domain.Domain;

/**
 * Sku结构
 * 
 * @author x.d zhang
 * 
 */
public class Sku extends Domain {

	private static final long serialVersionUID = 8558524674393512748L;

	/**
	 * sku的id
	 */
	private Long id;

	/**
	 * 产品ID
	 */
	private Long productid;

	/**
	 * 商品级别的条形码
	 */
	private String barcode;

	/**
	 * sku创建日期 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private String created;

	/**
	 * sku最后修改日期 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private String modified;

	/**
	 * 属于这个sku的商品的价格 取值范围:0-100000000;精确到2位小数;单位:元。如:200.07，表示:200元7分。
	 */
	private Double price;

	/**
	 * 产品的市场价格
	 */
	private Double mkprice = 0.00d;

	/**
	 * 产品的成本价格
	 */
	private Double cost;

	/**
	 * 商品的重量，用于按重量计费的运费模板。注意：单位为kg
	 */
	private Double weight;

	/**
	 * sku的销售属性组合字符串（颜色，大小，等等，可通过类目API获取某类目下的销售属性）,格式是p1:v1;p2:v2
	 */
	private String specIds;

	private String specValIds;

	/**
	 * sku所对应的销售属性的中文名字串，格式如：pid1:vid1:pid_name1:vid_name1;pid2:vid2:pid_name2:
	 * vid_name2……
	 */
	private String specStr;

	/**
	 * 属于这个sku的商品的数量，（库存）
	 */
	private Integer storenum;

	/**
	 * sku状态。 normal:正常 ；delete:删除
	 */
	private String status;

	/**
	 * 商品在付款减库存的状态下，该sku上未付款的订单数量
	 */
	private Integer locknum;

	/**
	 * 该SKU商品的销量
	 */
	private Integer salenum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSpecIds() {
		return specIds;
	}

	public void setSpecIds(String specIds) {
		this.specIds = specIds;
	}

	public String getSpecValIds() {
		return specValIds;
	}

	public void setSpecValIds(String specValIds) {
		this.specValIds = specValIds;
	}

	public String getSpecStr() {
		return specStr;
	}

	public void setSpecStr(String specStr) {
		this.specStr = specStr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Double getMkprice() {
		return mkprice;
	}

	public void setMkprice(Double mkprice) {
		this.mkprice = mkprice;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getStorenum() {
		return storenum;
	}

	public void setStorenum(Integer storenum) {
		this.storenum = storenum;
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

}
