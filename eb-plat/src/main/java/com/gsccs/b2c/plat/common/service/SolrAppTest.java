package com.gsccs.b2c.plat.common.service;

import java.util.ArrayList;
import java.util.List;

import com.gsccs.b2c.plat.common.model.TestGoods;

public class SolrAppTest {

	
	public static void main(String args[]) {
		SolrService solrS = new SolrService();
		solrS.init();
		solrS.remove();
		List<TestGoods> list = new ArrayList<TestGoods>();
		TestGoods g1 = new TestGoods();
		g1.setId(Long.valueOf(1000));
		g1.setBrandId("1000");
		g1.setPrice((float) 203.2);
		g1.setTitle("2015年计算机系统考试报名时间_程序员_软件工程师_系统分析师_系统架构师_网络工程师");
		g1.setCat(new String[] { "程序员", "软件工程师", "系统分析师", "系统架构师", "网络工程师" });
		g1.setFeatures(new String[] { "程序员", "软件工程师", "系统分析师", "系统架构师", "网络工程师" });
		list.add(g1);

		TestGoods g2 = new TestGoods();
		g2.setBrandId("1001");
		g2.setPrice((float) 3.9);
		g2.setId(Long.valueOf(1001));
		g2.setTitle("程序员分片查询， 可以统计关键字及出现的次数");
		g2.setCat(new String[] { "关键字", "自动补全", "系统分析师", "系统架构师", "网络工程师" });
		g2.setFeatures(new String[] { "关键字", "自动补全", "系统分析师", "系统架构师", "网络工程师" });
		list.add(g2);
		
		TestGoods g3 = new TestGoods();
		g3.setId(Long.valueOf(1002));
		g3.setBrandId("1002");
		g3.setPrice((float) 9007.9);
		g3.setTitle("或是做自动补全提示");
		g3.setCat(new String[] { "关键字", "自动补全", "系统分析师", "系统架构师", "网络工程师" });
		g3.setFeatures(new String[] { "关键字", "自动补全", "系统分析师", "系统架构师", "网络工程师" });
		list.add(g3);
		
		solrS.addBeans(list);
		solrS.queryAll();
		//solrS.facetQueryCase();
		solrS.destory();

	}

}
