package com.gsccs.b2c.api.domain;

import java.util.List;

/**
 * 商品批量操作返回结果
 * 
 * @author x.d zhang
 * 
 */
public class BatchOperateResult extends Domain {
	private static final long serialVersionUID = 5513696581637458647L;

	/**
	 * 商品操作错误代码
	 */
	private String errorCode;

	/**
	 * 操作提示
	 */
	private String errorMsg;

	/**
	 * 批量操作失败的宝贝列表
	 */
	private List<Long> failedItemList;

	/**
	 * 操作是否成功，只要有一个宝贝发布成功则返回true
	 */
	private Boolean success;

	/**
	 * 操作成功的宝贝id列表
	 */
	private List<Long> successItemList;

}
