package com.gsccs.eb.api.domain.goods;

import java.util.List;

import com.gsccs.eb.api.domain.base.Domain;

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
	private Long goodsid;
	
	private String title;

	/**
	 * 商品级别的条形码
	 */
	private String serial;

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
	private Double costprice;

	/**
	 * 商品的重量，用于按重量计费的运费模板。注意：单位为kg
	 */
	private Double weight;

	/**
	 * 属于这个sku的商品的数量，（库存）
	 */
	private Integer storenum;

	/**
	 * 商品在付款减库存的状态下，该sku上未付款的订单数量
	 */
	private Integer locknum;

	/**
	 * 该SKU商品的销量
	 */
	private Integer salenum;

	/**
	 * sku状态。 normal:正常 ；delete:删除
	 */
	private String status;

	private String specids;
	private String specstr;

	private List<SkuSpec> specList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
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

	public Double getMkprice() {
		return mkprice;
	}

	public void setMkprice(Double mkprice) {
		this.mkprice = mkprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Double getCostprice() {
		return costprice;
	}

	public void setCostprice(Double costprice) {
		this.costprice = costprice;
	}

	public String getSpecids() {
		return specids;
	}

	public void setSpecids(String specids) {
		this.specids = specids;
	}

	public String getSpecstr() {
		return specstr;
	}

	public void setSpecstr(String specstr) {
		this.specstr = specstr;
	}

	public List<SkuSpec> getSpecList() {
		return specList;
	}

	public void setSpecList(List<SkuSpec> specList) {
		this.specList = specList;
	}

}
