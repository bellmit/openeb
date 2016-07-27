package com.gsccs.b2c.solr.service;

import java.util.List;
import java.util.Map;

/**
 * 商品搜索结果集
 * 
 * @author x.d zhang
 * 
 */
public class SearchObj {

	private String id;
	private String site;
	private String title;
	private Double price;

	// 类目分组集合
	private Map<String, List<String>> cates;
	// 属性分组集合
	private Map<String, List<String>> props;
	// 品牌分组集合
	private Map<String, String> brands;
	
	

}
