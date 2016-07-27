package com.gsccs.eb.api.domain.goods;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;

public class PropImg extends Domain {

	private static final long serialVersionUID = 7777174413466839242L;

	/**
	 * 图片创建时间 时间格式：yyyy-MM-dd HH:mm:ss
	 */
	private Date created;

	/**
	 * 属性图片的id，和商品相对应
	 */
	private Long id;

	/**
	 * 图片放在第几张（多图时可设置）
	 */
	private Long position;

	/**
	 * 图片所对应的属性组合的字符串
	 */
	private String properties;

	/**
	 * 图片链接地址
	 */
	private String url;
}
