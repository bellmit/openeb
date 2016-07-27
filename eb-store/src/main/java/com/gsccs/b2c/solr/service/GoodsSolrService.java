package com.gsccs.b2c.solr.service;

public interface GoodsSolrService {

	/**
	 * 添加商品索引(根据站点id添加该站点下所有商品到solr)
	 * @param sid
	 */
	public void addGoodsSolrBySite(Long sid,int page,int rows);
	/**
	 * 添加商品索引(根据站点id和产品id添加索引)
	 * @param sid
	 * @param pid
	 */
	public void addGoodsSolrBySiteAndPid(Long sid,Long pid);
}
