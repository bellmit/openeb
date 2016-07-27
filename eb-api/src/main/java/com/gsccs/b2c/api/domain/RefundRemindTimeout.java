package com.gsccs.b2c.api.domain;

import java.util.Date;

/**
 * 退款超时
 * @author x.d zhang
 *
 */
public class RefundRemindTimeout extends DomainObject {

	private static final long serialVersionUID = 4765835537341541713L;

	/**
	 * 是否存在超时。可选值:true(是),false(否)
	 */
	private Boolean existTimeout;

	/**
	 * 提醒的类型（退款详情中提示信息的类型）
	 */
	private Long remindType;

	/**
	 * 超时时间。格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date timeout;
}
