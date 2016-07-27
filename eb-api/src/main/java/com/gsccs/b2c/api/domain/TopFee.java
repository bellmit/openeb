package com.gsccs.b2c.api.domain;


/**
 * 运费模板中运费信息对象
 * @author x.d zhang
 *
 */
public class TopFee extends DomainObject {
	
	private static final long serialVersionUID = 1115759694374364796L;

	/**
	 * 增费：输入0.00-999.99（最多包含两位小数） 不能为空不输入运费时必须输入0
	 */
	private String addFee;

	/**
	 * 增费标准：当valuation(记价方式)为0时输入1-9999范围内的整数
	 */
	private String addStandard;

	/**
	 * 邮费子项涉及的地区,多个地区用逗号连接数量串;
	 */
	private String destination;

	/**
	 * 可选值：post:平邮; cod:货到付款; ems:EMS; express:快递公司
	 */
	private String serviceType;

	/**
	 * 首费：输入0.01-999.99（最多包含两位小数） 不能为空也不能为0
	 */
	private String startFee;

	/**
	 * 首费标准：当valuation(记价方式)为0时输入1-9999范围内的整数
	 */
	private String startStandard;


}
