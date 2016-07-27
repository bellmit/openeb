package com.gsccs.eb.api.domain.goods;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;

/**
 * 产品图片
 * 
 * @author x.d zhang
 * 
 */
public class Attach extends Domain {
	
	private static final long serialVersionUID = 6161182663923237286L;

	/**
	 * 产品图片ID
	 */
	private Long id;

	/**
	 * 修改时间.格式:yyyy-mm-dd hh:mm:ss
	 */
	private Date modified;

	/**
	 * 图片序号。产品里的图片展示顺序，数据越小越靠前。要求是正整数。
	 */
	private Long position;

	/**
	 * 图片所属产品的ID
	 */
	private Long productId;

	/**
	 * 图片地址.(绝对地址,格式:http://host/image_path)
	 */
	private String url;
	
	/**
	 * 添加时间.格式:yyyy-mm-dd hh:mm:ss
	 */
	private Date created;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
