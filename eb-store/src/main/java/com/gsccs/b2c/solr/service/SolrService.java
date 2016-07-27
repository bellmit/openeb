package com.gsccs.b2c.solr.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse.Suggestion;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class SolrService {

	private String host;
	private SolrServer server;

	//private static final String DEFAULT_URL_ = "http://192.168.72.129:8983/solr/";
	private static final String DEFAULT_URL = "http://10.209.1.131:8983/solr/";

	public void init() {
		server = new HttpSolrServer(DEFAULT_URL);
	}

	public void destory() {
		server = null;
		System.runFinalization();
		System.gc();
	}

	public final void fail(Object o) {
		System.out.println(o);
	}

	/**
	 * 测试是否创建server对象成功
	 * 
	 */
	public void server() {
		fail(server);
	}

	public void addBeans(List<GoodsSolr> list) {
		try {
			// 添加索引库
			UpdateResponse response = server.addBeans(list);
			// commit后才保存到索引库
			fail(server.commit());
			fail(response);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 处理查询条件
	 * 
	 * @param query
	 * @param param
	 */
	private void prefixParam(SolrQuery query, QueryParam param) {
		// 分站点查询
		if (StringUtils.isNotEmpty(param.getSiteId())) {
			query.addFilterQuery("siteid:" + param.getSiteId());
		}

		//
		if (StringUtils.isNotEmpty(param.getKeyword())) {
			query.addFilterQuery("title:" + param.getKeyword());
		}

		if (StringUtils.isNotEmpty(param.getCateId())) {
			query.addFilterQuery("cateid:" + param.getCateId());
		}

		if (null != param.getBrandIds() && param.getBrandIds().length > 0) {
			String str = "";
			for (int i = 0; i < param.getBrandIds().length; i++) {
				str = str + " brandid:" + param.getBrandIds()[i];
				if (i < param.getBrandIds().length - 1) {
					str = str + " OR ";
				}
			}
			if (str.trim().length() > 0) {
				query.addFilterQuery(str);
			}
		}

		if (null != param.getAttrIds() && param.getAttrIds().length > 0) {
			String str = "";
			for (int i = 0; i < param.getAttrIds().length; i++) {
				str = str + " attrid:" + param.getAttrIds()[i];
				if (i < param.getAttrIds().length - 1) {
					str = str + " OR ";
				}
			}
			if (str.trim().length() > 0) {
				query.addFilterQuery(str);
			}
		}

		if (null != param.getAttrValIds() && param.getAttrValIds().length > 0) {
			String str = "";
			for (int i = 0; i < param.getAttrValIds().length; i++) {
				str = str + " attrvalid:" + param.getAttrValIds()[i];
				if (i < param.getAttrValIds().length - 1) {
					str = str + " OR ";
				}
			}
			if (str.trim().length() > 0) {
				query.addFilterQuery(str);
			}
		}

		if (null != param.getMinPrice() && null != param.getMaxPrice()) {
			query.setQuery("price:[" + param.getMinPrice() + " TO "
					+ param.getMaxPrice() + "]");
		} else if (null != param.getMinPrice()) {
			query.setQuery("price:[" + param.getMinPrice() + " TO *]");
		} else if (null != param.getMaxPrice()) {
			query.setQuery("price:[* TO " + param.getMaxPrice() + "]");
		}

	}

	/**
	 * 查询列表
	 * 
	 * @param param
	 */
	public JSONArray goodsQuery(QueryParam param) {
		SolrQuery query = new SolrQuery("*:*");
		// 处理查询参数
		prefixParam(query, param);

		// 分页
		query.set("start", param.getStart());
		query.set("rows", param.getRows());

		// 排序
		query.set("sort", param.getOrder());
		QueryResponse response;

		try {
			response = server.query(query);
			// 输出查询结果集
			SolrDocumentList goodsList = response.getResults();
			return (JSONArray) JSON.toJSON(goodsList);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 属性分组
	 * 
	 * @return
	 */
	public JSONObject facetQuery(QueryParam param) {
		JSONObject json = new JSONObject();
		SolrQuery query = new SolrQuery("*:*");
		query.setFacet(true).setFacetMinCount(1)
				// .setFacetLimit(5)
				.addFacetField("catestr").addFacetField("brandstr")
				.addFacetField("attrstr").addFacetField("attrvalstr");

		// 处理查询参数
		prefixParam(query, param);

		try {
			List<Count> attrFacets = new ArrayList<FacetField.Count>();
			List<Count> attrValsFacets = new ArrayList<FacetField.Count>();
			List<Count> brandFacets = new ArrayList<FacetField.Count>();
			List<Count> cateFacets = new ArrayList<FacetField.Count>();
			QueryResponse response = server.query(query);
			long total = response.getResults().getNumFound();
			// 输出分片信息
			List<FacetField> facets = response.getFacetFields();
			for (FacetField facet : facets) {
				// 类目项
				if (facet.getName().equals("catestr")) {
					cateFacets = facet.getValues();
					// json.put(facet.getName(), facet.getValues());
				}

				// 品牌项
				if (facet.getName().equals("brandstr")) {
					brandFacets = facet.getValues();
				}

				// 属性项
				if (facet.getName().equals("attrstr")) {
					attrFacets = facet.getValues();
				}

				// 属性值项
				if (facet.getName().equals("attrvalstr")) {
					attrValsFacets = facet.getValues();
				}
			}

			List<Map<String, Object>> cateList = new ArrayList<Map<String, Object>>();
			if (cateFacets.size() > 0) {
				Map<String, Object> map = null;
				for (Count c : cateFacets) {
					map = new HashMap<String, Object>();
					if (StringUtils.isNotEmpty(c.getName())
							&& c.getName().split("-").length > 1) {
						map.put("id", c.getName().split("-")[0]);
						map.put("title", c.getName().split("-")[1]+ "(" + c.getCount()
								+ ")");
						cateList.add(map);
					}
				}
			}

			List<Map<String, Object>> brandList = new ArrayList<Map<String, Object>>();
			if (brandFacets.size() > 0) {
				Map<String, Object> map = null;
				for (Count c : brandFacets) {
					map = new HashMap<String, Object>();
					if (StringUtils.isNotEmpty(c.getName())
							&& c.getName().split("-").length > 1) {
						map.put("id", c.getName().split("-")[0]);
						map.put("title", c.getName().split("-")[1]+ "(" + c.getCount()
								+ ")");
						brandList.add(map);
					}
				}
			}

			// 查询条件属性值
			Map<String, String> condictAttrVal = new HashMap<String, String>();

			// 搜索结果属性值
			Map<String, List<Map<String, Object>>> attrvalMap = new HashMap<String, List<Map<String, Object>>>();
			if (attrValsFacets.size() > 0) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Map<String, Object>> valList = null;
				for (Count c : attrValsFacets) {
					if (null != param.getAttrValIds()
							&& param.getAttrValIds().length > 0) {
						for (String id : param.getAttrValIds()) {
							if (id.equals(c.getName().split("-")[0])) {
								condictAttrVal.put(c.getName().split("-")[0], c
										.getName().split("-")[1]);
								break;
							}
						}
					}

					map = new HashMap<String, Object>();
					map.put("id", c.getName().split("-")[0]);
					map.put("title",
							c.getName().split("-")[1] + "(" + c.getCount()
									+ ")");
					valList = attrvalMap.get(c.getName().split("-")[0]
							.split("_")[0]);
					if (null == valList) {
						valList = new ArrayList<Map<String, Object>>();
					}
					valList.add(map);
					attrvalMap.put(c.getName().split("-")[0].split("_")[0],
							valList);
				}
			}

			// 搜索结果属性列表
			List<Map<String, Object>> attrList = new ArrayList<Map<String, Object>>();
			// 查询条件属性
			Map<String, String> condictAttr = new HashMap<String, String>();

			if (attrFacets.size() > 0) {
				Map<String, Object> map = null;
				boolean flag = true;
				for (Count c : attrFacets) {
					if (null != param.getAttrIds()
							&& param.getAttrIds().length > 0) {
						for (String id : param.getAttrIds()) {
							if (id.equals(c.getName().split("-")[0])) {
								flag = false;
								break;
							}
						}
					}
					if (flag) {
						map = new HashMap<String, Object>();
						map.put("id", c.getName().split("-")[0]);
						map.put("title", c.getName().split("-")[1]);
						List list = attrvalMap.get(c.getName().split("-")[0]);
						if (null != list && list.size() > 0) {
							map.put("vals", list);
							attrList.add(map);
						}
					} else {
						String key_ = c.getName().split("-")[0];
						condictAttr.put(key_, c.getName().split("-")[1]);
					}

				}
			}

			// 查询条件组合
			if (null != condictAttrVal) {
				Iterator<String> its = condictAttrVal.keySet().iterator();
				while (its.hasNext()) {
					String valkey = its.next();
					String valtitle = condictAttrVal.get(valkey);
					String attrtitle = condictAttr.get(valkey.split("_")[0]);
					condictAttrVal.put(valkey, attrtitle + ":" + valtitle);
				}
				json.put("conditions_data", condictAttrVal);
			}

			if (null != cateList) {
				json.put("cate_data", cateList);
			}

			if (null != brandList) {
				json.put("brand_data", brandList);
			}
			if (null != attrList) {
				json.put("attr_data", attrList);
			}
			
			json.put("total",total);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json;
	}

	public void remove() {
		try {
			// 删除id为1的索引
			server.deleteByQuery("*:*");
			server.commit();

			/*
			 * // 根据id集合，删除多个索引 List<String> ids = new ArrayList<String>();
			 * ids.add("2"); ids.add("3"); server.deleteById(ids);
			 * server.commit(true, true); query("id:3 id:2");
			 * 
			 * // 删除查询到的索引信息 server.deleteByQuery("id:4 id:6");
			 * server.commit(true, true);
			 */
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自动补全功能
	 * 
	 * @param word
	 * @return
	 */
	public List<String> suggest(String word) {

		List<String> wordList = new ArrayList<String>();

		SolrQuery query = new SolrQuery();
		query.set("q", "name_autocomplete:" + word);// 查询的词
		query.set("qt", "/suggest");// 请求到suggest中
		query.set("spellcheck.count", "10");// 返回数量
		QueryResponse rsp;
		try {
			rsp = server.query(query);
			SpellCheckResponse re = rsp.getSpellCheckResponse();// 获取拼写检查的结果集
			if (re != null) {
				for (Suggestion s : re.getSuggestions()) {
					List<String> list = s.getAlternatives();// 获取所有 的检索词
					for (String spellWord : list) {
						wordList.add(spellWord);
					}
					return wordList;// 建议词汇
				}
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * public JSONObject facetQuery(String siteId, String key, String cateId,
	 * String brandIds[], String[] attrIds, String[] attrValIds, Integer
	 * minPrice, Integer maxPrice) {
	 * 
	 * }
	 */

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
