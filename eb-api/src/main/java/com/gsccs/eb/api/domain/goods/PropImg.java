package com.gsccs.eb.api.domain.goods;

import java.util.Date;

import com.gsccs.b2c.api.domain.Domain;


/**
 * 产品属性图片
 * @author x.d zhang
 *
 */
public class PropImg extends Domain {

	private static final long serialVersionUID = 5157889266738967481L;

	/**
	 * 添加时间.格式:yyyy-mm-dd hh:mm:ss
	 */
	private Date created;

	/**
	 * 产品属性图片ID
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
	 * 属性串(pid:vid),目前只有颜色属性.如:颜色:红色表示为　1627207:28326
	 */
	private String props;

	/**
	 * 图片地址.(绝对地址,格式:http://host/image_path)
	 */
	private String url;
}
