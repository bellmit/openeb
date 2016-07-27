package com.gsccs.eb.api.domain.site;

import java.io.Serializable;
import java.util.List;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 首页楼层信息
 * 
 * @author ZhangTao
 * 
 */
public class Storey extends Domain {

	private static final long serialVersionUID = -8924023754056106780L;

	private Long id;
	private String title;
	private String titleLine;
	private String icon;
	
	private String bgColor;

	private String mainImg;

	private String mainImgline;

	private Integer orderNum;

	/**
	 * 保存数据所用的属性
	 */
	private String cate;
	private String brand;
	private String goods;
	
	private List<IndexCate> indexCates;

	private List<IndexBrand> indexBrands;

	private List<IndexImg> indexImgs;

	

	/**
	 * 首页楼层类目
	 */
	public static class IndexCate implements Serializable{
		
		private String cateTitle;
		private String cateLine;

		public String getCateTitle() {
			return cateTitle;
		}

		public void setCateTitle(String cateTitle) {
			this.cateTitle = cateTitle;
		}

		public String getCateLine() {
			return cateLine;
		}

		public void setCateLine(String cateLine) {
			this.cateLine = cateLine;
		}
	}

	
	/**
	 * 首页楼层品牌
	 */
	public static class IndexBrand implements Serializable{
		
		private String brandImg;
		private String brandLine;

		public String getBrandImg() {
			return brandImg;
		}

		public void setBrandImg(String brandImg) {
			this.brandImg = brandImg;
		}

		public String getBrandLine() {
			return brandLine;
		}

		public void setBrandLine(String brandLine) {
			this.brandLine = brandLine;
		}
	}

	/**
	 * 首页楼层图片
	 */
	public static class IndexImg implements Serializable {
		private static final long serialVersionUID = 1L;
		private String img;
		private String imgLine;

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public String getImgLine() {
			return imgLine;
		}

		public void setImgLine(String imgLine) {
			this.imgLine = imgLine;
		}
	}


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
		this.title = title;
	}

	public String getTitleLine() {
		return titleLine;
	}

	public void setTitleLine(String titleLine) {
		this.titleLine = titleLine;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public String getMainImgline() {
		return mainImgline;
	}

	public void setMainImgline(String mainImgline) {
		this.mainImgline = mainImgline;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public List<IndexCate> getIndexCates() {
		return indexCates;
	}

	public void setIndexCates(List<IndexCate> indexCates) {
		this.indexCates = indexCates;
	}

	public List<IndexBrand> getIndexBrands() {
		return indexBrands;
	}

	public void setIndexBrands(List<IndexBrand> indexBrands) {
		this.indexBrands = indexBrands;
	}

	public List<IndexImg> getIndexImgs() {
		return indexImgs;
	}

	public void setIndexImgs(List<IndexImg> indexImgs) {
		this.indexImgs = indexImgs;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	//
	public class StoreyCate {

	}
	
	

}
