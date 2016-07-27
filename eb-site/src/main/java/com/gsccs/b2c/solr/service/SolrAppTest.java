package com.gsccs.b2c.solr.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @author x.d zhang
 * 
 */
public class SolrAppTest {

	public static void main(String args[]) {
		//solrtest();
		//suggestTest();
		
		ProductDataInit datainit = new ProductDataInit();
		try {
			datainit.addData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void suggestTest(){
		SolrService solrS = new SolrService();
		solrS.init();
		try {
			solrS.suggest("暴");
			solrS.destory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void solrtest() {

		SolrService solrS = new SolrService();
		solrS.init();
		solrS.remove();

		List<TestGoods> list = new ArrayList<TestGoods>();
		
		for(int i =0;i<40;i++){
			TestGoods g1 = new TestGoods();
			g1.setId("10"+i);
			g1.setBrandid("1000");
			g1.setBrandstr("1000-暴风魔镜");
			g1.setPrice((float) 203.2);
			
			g1.setSiteid("1001");
			g1.setCateid("1010");
			g1.setCatestr("1010-测试类目1010");
			g1.setTitle("暴风影音魔镜暴风魔镜2 虚拟现实眼镜 头戴3D魔镜虚拟现实手机头盔 包邮 正品保障");
			
			g1.setAttrid(new String[] { "101", "102" });
			g1.setAttrstr(new String[] { "101-功能", "102-适用人群" });
			g1.setAttrvalid(new String[] { "101_103", "102_102" });
			g1.setAttrvalstr(new String[] { "101_103-其它", "102_102-大众通用" });
			list.add(g1);
			
		}
		

		TestGoods g11 = new TestGoods();
		g11.setId("10011");
		g11.setSiteid("1001");
		g11.setSiteid("1001");
		g11.setCateid("1010");
		g11.setCatestr("1010-测试类目1010");
		
		g11.setBrandid("1000");
		g11.setBrandstr("1000-暴风魔镜");
		g11.setPrice((float) 203.2);
		g11.setTitle("暴风魔镜手工体验版 暴风影音魔镜 ");
		g11.setAttrid(new String[] { "101", "102" });
		g11.setAttrstr(new String[] { "101-功能", "102-适用人群" });
		g11.setAttrvalid(new String[] { "101_101", "102_101" });
		g11.setAttrvalstr(new String[] { "101_101-社交", "102_101-男士" });
		list.add(g11);

		TestGoods g12 = new TestGoods();
		g12.setSiteid("1001");
		g12.setCateid("1010");
		g12.setId("10012");
		g12.setBrandid("1000-暴风魔镜");
		g12.setPrice((float) 203.2);
		g12.setTitle("3D虚拟现实眼镜头盔，影院观影效果，左右3D视频眼镜");
		g12.setAttrid(new String[] { "101", "102" });
		g12.setAttrstr(new String[] { "101-功能", "102-适用人群" });
		g12.setAttrvalid(new String[] { "101_102", "102_102" });
		g12.setAttrvalstr(new String[] { "101_102-娱乐", "102_102-大众通用" });
		list.add(g12);

		TestGoods g6 = new TestGoods();
		g6.setSiteid("1001");
		g6.setCateid("1010");
		g6.setId("1006");
		g6.setBrandid("1006_ENMESI");
		g6.setPrice((float) 203.2);
		g6.setTitle("ENMESI 智能眼镜 视频便携WIFI无线头戴显示器 3D智能移动影院 虚拟现实智能设备 黑色");
		g6.setAttrid(new String[] { "101", "102" });
		g6.setAttrstr(new String[] { "101-功能", "102-适用人群" });
		g6.setAttrvalid(new String[] { "101_102", "102_103" });
		g6.setAttrvalstr(new String[] { "101_102-娱乐", "102_103-情侣时尚" });
		list.add(g6);

		TestGoods g7 = new TestGoods();
		g7.setSiteid("1001");
		g7.setCateid("1010");
		g7.setId("1007");
		g7.setBrandid("1007_Wtitech");
		g7.setPrice((float) 203.2);
		g7.setTitle(" Y1 智能蓝牙眼镜 立体声蓝牙太阳镜 偏光灰镜片");
		g7.setAttrid(new String[] { "101", "102" });
		g7.setAttrstr(new String[] { "101-功能", "102-适用人群" });
		g7.setAttrvalid(new String[] { "101_102", "102_103" });
		g7.setAttrvalstr(new String[] { "101_102-娱乐", "102_103-情侣时尚" });
		list.add(g7);

		TestGoods g2 = new TestGoods();
		g2.setSiteid("1001");
		g2.setCateid("1010");
		g2.setBrandid("1002");
		g2.setPrice((float) 3.9);
		g2.setId("1002");
		g2.setTitle("Scrum精髓：敏捷转型指南");
		g2.setAttrid(new String[] { "201", "202", "203" });
		g2.setAttrstr(new String[] { "201-出版社", "202-类型", "203-包装" });
		g2.setAttrvalid(new String[] { "201_2002", "202_2003", "202_2004" });
		g2.setAttrvalstr(new String[] { "201_2002-清华大学出版社", "202_2003-软件开发",
				"202_2004-平装" });
		list.add(g2);

		TestGoods g21 = new TestGoods();
		g21.setSiteid("1001");
		g21.setCateid("1010");
		g21.setBrandid("10021");
		g21.setPrice((float) 3.9);
		g21.setId("10021");
		g21.setTitle("Netty权威指南");
		g21.setAttrid(new String[] { "201", "202", "203" });
		g21.setAttrstr(new String[] { "201-出版社", "202-类型", "203-包装" });
		g21.setAttrvalid(new String[] { "201_2001", "202_2003", "202_2004" });
		g21.setAttrvalstr(new String[] { "201_2001-电子工业出版社", "202_2003-软件开发",
				"202_2003-平装" });
		list.add(g21);

		TestGoods g3 = new TestGoods();
		g3.setSiteid("1001");
		g3.setCateid("1010");
		g3.setId("1003");
		g3.setBrandid("1003");
		g3.setPrice((float) 9007.9);
		g3.setTitle("森果 办公桌 开会用桌子家具 板式方形木质会议桌简约时尚 会议洽谈桌 ");
		list.add(g3);

		TestGoods g4 = new TestGoods();
		g4.setSiteid("1001");
		g4.setId("1004");
		g4.setBrandid("1004");
		g4.setPrice((float) 9007.9);
		g4.setTitle("木玩世家 全家欢 儿童益智木制玩具100粒6岁以下宝宝桶装大块积木 ");
		list.add(g4);

		TestGoods g5 = new TestGoods();
		g5.setId("1005");
		g5.setBrandid("1005_纽曼（Newmine）");
		g5.setPrice((float) 9007.9);
		g5.setTitle("纽曼（Newmine） NM-LDX 来电通 高效办公轻松实现 ");
		list.add(g5);

		solrS.addBeans(list);
		//solrS.queryAll();
		// solrS.facetQuery("",0,0);
		/*
		 * solrS.facetQuery("", "", "", new String[] {}, new String[] { "101",
		 * "102" }, new String[] { "101_102", "102_103" });
		 */
		/*solrS.facetQuery("", "", "", new String[] {}, new String[] {},
				new String[] {},null,null);*/
		solrS.destory();
	}

	
	
	public static void jsontest() {
		// List<List<Map<String, Object>>> list = new ArrayList<List<Map<String,
		// Object>>>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", "101");
		map1.put("title", "功能");
		List<Map<String, String>> vallist1 = new ArrayList<Map<String, String>>();
		Map<String, String> val11 = new HashMap<String, String>();
		val11.put("id", "101_102");
		val11.put("title", "娱乐 (3)");
		vallist1.add(val11);
		Map<String, String> val12 = new HashMap<String, String>();
		val12.put("id", "101_103");
		val12.put("title", "社交 (2)");
		vallist1.add(val12);
		map1.put("vals", vallist1);
		list.add(map1);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", "102");
		map2.put("title", "适用人群 ");
		List<Map<String, String>> vallist2 = new ArrayList<Map<String, String>>();
		Map<String, String> val21 = new HashMap<String, String>();
		val21.put("id", "102_102");
		val21.put("title", "男士 (3)");
		vallist2.add(val21);
		Map<String, String> val22 = new HashMap<String, String>();
		val22.put("id", "102_103");
		val22.put("title", "情侣时尚 (2)");
		vallist2.add(val22);
		map2.put("vals", vallist2);
		list.add(map2);

		JSONArray jarr = new JSONArray();
		jarr.addAll(list);

		System.out.println(jarr.toJSONString());
	}
}
