package com.gsccs.b2c.api.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 首页楼层信息
 * 
 * @author ZhangTao
 * 
 */
public class IndexBrands extends Domain {

	private static final long serialVersionUID = -8295456690151511775L;
	
	private Long id;
	private String hotBrand1;
	private String hotBrand2;
	private String hotBrandLine1;
	private String hotBrandLine2;

	/**
	 * 保存数据所用的属性
	 */
	private String brand;
	
	private List<HotBrand> hotBrands;

	/**
	 * 热门品牌
	 */
	public static class HotBrand implements Serializable{
		private static final long serialVersionUID = 3594704444910749939L;
		private String hotBrand;
		private String hotBrandLine;
		
		public String getHotBrand() {
			return hotBrand;
		}
		public void setHotBrand(String hotBrand) {
			this.hotBrand = hotBrand;
		}
		public String getHotBrandLine() {
			return hotBrandLine;
		}
		public void setHotBrandLine(String hotBrandLine) {
			this.hotBrandLine = hotBrandLine;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotBrand1() {
		return hotBrand1;
	}

	public void setHotBrand1(String hotBrand1) {
		this.hotBrand1 = hotBrand1;
	}

	public String getHotBrand2() {
		return hotBrand2;
	}

	public void setHotBrand2(String hotBrand2) {
		this.hotBrand2 = hotBrand2;
	}

	public String getHotBrandLine1() {
		return hotBrandLine1;
	}

	public void setHotBrandLine1(String hotBrandLine1) {
		this.hotBrandLine1 = hotBrandLine1;
	}

	public String getHotBrandLine2() {
		return hotBrandLine2;
	}

	public void setHotBrandLine2(String hotBrandLine2) {
		this.hotBrandLine2 = hotBrandLine2;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<HotBrand> getHotBrands() {
		return hotBrands;
	}

	public void setHotBrands(List<HotBrand> hotBrands) {
		this.hotBrands = hotBrands;
	}
}
