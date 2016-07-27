package com.gsccs.b2c.api.exception;

import com.gsccs.b2c.api.exception.ApiException;

/**
 * API前置检查异常。
 * 
 * @author x.d zhang
 * @since 1.0
 */
public class ApiRuleException extends ApiException {

	private static final long serialVersionUID = -7787145910600194272L;

	public ApiRuleException(String errCode, String errMsg) {
		super(errCode, errMsg);
	}

}
