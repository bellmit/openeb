package com.gsccs.b2c.api.domain;

import java.util.Date;

/**
 * ItemImg结构
 * @author x.d zhang
 *
 */
public class ItemImg extends Domain {
	
	private static final long serialVersionUID = 4626594717913552816L;

	/**
	 * 图片创建时间 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date created;

	/**
	 * 商品图片的id，和商品相对应（主图id默认为0）
	 */
	private Long id;

	/**
	 * 图片放在第几张（多图时可设置）
	 */
	private Long position;

	/**
	 * 图片链接地址
	 */
	private String url;


}
