package com.gsccs.b2c.plat.common.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.params.SolrParams;

import com.gsccs.b2c.plat.common.model.TestGoods;

public class SolrService {

	private SolrServer server;

	private static final String DEFAULT_URL = "http://172.16.10.86:8983/solr/";

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

	public void addBeans(List<TestGoods> list) {
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

	public void queryAll() {
		
		
		ModifiableSolrParams params = new ModifiableSolrParams();
		// 查询关键词，*:*代表所有属性、所有值，即所有index
		params.set("q", "*:*");
		// 分页，start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。
		params.set("start", 0);
		params.set("rows", Integer.MAX_VALUE);

		// 排序，，如果按照id 排序，，那么将score desc 改成 id desc(or asc)
		params.set("sort", "score desc");

		// 返回信息 * 为全部 这里是全部加上score，如果不加下面就不能使用score
		params.set("fl", "*,score");

		try {
			QueryResponse response = server.query(params);

			SolrDocumentList list = response.getResults();
			Integer counts = (int) list.getNumFound();
			
			for (int i = 0; i < list.size(); i++) {
				fail(list.get(i));
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据query参数查询索引
	 * 
	 * @param query
	 */
	public void query(String query) {
		SolrParams params = new SolrQuery(query);
		try {
			QueryResponse response = server.query(params);

			SolrDocumentList list = response.getResults();
			for (int i = 0; i < list.size(); i++) {
				fail(list.get(i));
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 分片查询、统计
	 */
	public void facetQueryCase() {
		SolrQuery params = new SolrQuery("*:*");
		// 排序
		params.addSortField("id", ORDER.asc);

		params.setStart(0);
		params.setRows(200);

		// Facet为solr中的层次分类查询
		// 分片信息
		params.setFacet(true).setQuery("*:*").setFacetMinCount(1)
				.setFacetLimit(5)// 段
				// .setFacetPrefix("关键")// 查询title、cat中关键字前缀是"关键"的
				// .addFacetField("title")
				// .addFacetField("features")
				// .addFacetField("price")
				.addFacetField("cat");// 分片字段

		// 50 <= price <= 200
		// params.setQuery("price:[50 TO 200]");
		// params.setQuery("brandId:1002");
		// params.addFacetQuery("cat:程序员");
		params.addFilterQuery("title:程序 OR cat:程序");
		try {
			QueryResponse response = server.query(params);
			// 输出查询结果集
			SolrDocumentList list = response.getResults();
			fail("Query result nums: " + list.getNumFound());

			for (int i = 0; i < list.size(); i++) {
				fail(list.get(i));
			}

			fail("All facet filed result: ");
			// 输出分片信息
			List<FacetField> facets = response.getFacetFields();
			for (FacetField facet : facets) {
				fail(facet);
				List<Count> facetCounts = facet.getValues();
				for (FacetField.Count count : facetCounts) {
					// 关键字 - 出现次数
					fail(count.getName() + ": " + count.getCount());
				}
			}

			/*
			 * fail("Search facet [name] filed result: "); // 输出分片信息 FacetField
			 * facetField = response.getFacetField("title"); List<Count>
			 * facetFields = facetField.getValues(); for (Count count :
			 * facetFields) { // 关键字 - 出现次数 fail(count.getName() + ": " +
			 * count.getCount()); }
			 */
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	
	
	public void queryCase() {
		// AND 并且
		SolrQuery params = new SolrQuery("name:apple AND manu:inc");

		// OR 或者
		params.setQuery("name:apple OR manu:apache");
		// 空格 等同于 OR
		params.setQuery("name:server manu:dell");

		// params.setQuery("name:solr - manu:inc");
		// params.setQuery("name:server + manu:dell");

		// 查询name包含solr apple
		params.setQuery("name:solr,apple");
		// manu不包含inc
		params.setQuery("name:solr,apple NOT manu:inc");

		// 50 <= price <= 200
		params.setQuery("price:[50 TO 200]");
		params.setQuery("popularity:[5 TO 6]");
		// params.setQuery("price:[50 TO 200] - popularity:[5 TO 6]");
		// params.setQuery("price:[50 TO 200] + popularity:[5 TO 6]");

		// 50 <= price <= 200 AND 5 <= popularity <= 6
		params.setQuery("price:[50 TO 200] AND popularity:[5 TO 6]");
		params.setQuery("price:[50 TO 200] OR popularity:[5 TO 6]");

		// 过滤器查询，可以提高性能 filter 类似多个条件组合，如and
		// params.addFilterQuery("id:VA902B");
		// params.addFilterQuery("price:[50 TO 200]");
		// params.addFilterQuery("popularity:[* TO 5]");
		// params.addFilterQuery("weight:*");
		// 0 < popularity < 6 没有等于
		// params.addFilterQuery("popularity:{0 TO 6}");

		// 排序
		params.addSortField("id", ORDER.asc);

		// 分页：start开始页，rows每页显示记录条数
		// params.add("start", "0");
		// params.add("rows", "200");
		// params.setStart(0);
		// params.setRows(200);

		// 设置高亮
		params.setHighlight(true); // 开启高亮组件
		params.addHighlightField("name");// 高亮字段
		params.setHighlightSimplePre("<font color='red'>");// 标记，高亮关键字前缀
		params.setHighlightSimplePost("</font>");// 后缀
		params.setHighlightSnippets(1);// 结果分片数，默认为1
		params.setHighlightFragsize(1000);// 每个分片的最大长度，默认为100

		// 分片信息
		params.setFacet(true).setFacetMinCount(1).setFacetLimit(5)// 段
				.addFacetField("name")// 分片字段
				.addFacetField("inStock");

		// params.setQueryType("");

		try {
			QueryResponse response = server.query(params);

			/*
			 * List<Index> indexs = response.getBeans(Index.class); for (int i =
			 * 0; i < indexs.size(); i++) { fail(indexs.get(i)); }
			 */

			// 输出查询结果集
			SolrDocumentList list = response.getResults();
			fail("query result nums: " + list.getNumFound());
			for (int i = 0; i < list.size(); i++) {
				fail(list.get(i));
			}

			// 输出分片信息
			List<FacetField> facets = response.getFacetFields();
			for (FacetField facet : facets) {
				fail(facet);
				List<Count> facetCounts = facet.getValues();
				for (FacetField.Count count : facetCounts) {
					System.out.println(count.getName() + ": "
							+ count.getCount());
				}
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
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

}
