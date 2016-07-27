package com.gsccs.b2c.plat.bass.service;


/**
 * 数据库分库分表服务接口
 * @author x.d zhang
 *
 */
public interface DBSplitService {
	
	/**
	 * 获取某类业务表名前缀
	 * @param type
	 */
	public void getDbTNPrefix(String type);
}
