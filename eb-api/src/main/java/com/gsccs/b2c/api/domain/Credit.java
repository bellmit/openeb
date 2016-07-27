package com.gsccs.b2c.api.domain;

/**
 * 用户信用
 * @author x.d zhang
 *
 */
public class Credit extends Domain {

	
	private static final long serialVersionUID = 8259596521657822744L;

	/**
	 * 收到的好评总条数。取值范围:大于零的整数
	 */
	private Long goodNum;

	/**
	 * 信用等级（是根据score生成的），信用等级：淘宝会员在淘宝网上的信用度，分为20个级别，级别如：level = 1 时，表示一心；level = 2 时，表示二心
	 */
	private Long level;

	/**
	 * 信用总分（“好评”加一分，“中评”不加分，“差评”扣一分。分越高，等级越高）
	 */
	private Long score;

	/**
	 * 收到的评价总条数。取值范围:大于零的整数
	 */
	private Long totalNum;
}
