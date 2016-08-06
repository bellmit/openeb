package com.gsccs.b2c.plat.deliver.service;

import java.util.List;

import com.gsccs.eb.api.domain.deliver.Corp;
import com.gsccs.eb.api.domain.deliver.Templet;

/**
 * @说明 商品货运物流接口 快递物流订单查询服务比如申通快递、顺丰快递、圆通快递、EMS快递、汇通快递、宅急送快递等
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 上午9:33:36
 */
public interface DeliverService {

	// 物流公司信息保存
	public void saveCorp(Corp corp);

	// 根据ID删除物流公司信息
	public void deleteCorp(Integer id);

	// 根据ID查询一条物流公司信息
	public Corp getCorp(Integer id);

	/**
	 * 分页查询物流公司信息
	 * 
	 * @param t
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param cache
	 * @return
	 */
	public List<Corp> find(Corp t, String order, int currPage, int pageSize,
			boolean cache);

	/**
	 * 根据条件查询物流公司信息条数
	 * 
	 * @param t
	 * @return
	 */
	public int count(Corp t);

	/**
	 * 保存配送方式
	 * 
	 * @param deliverCorpT
	 */
	public void saveType(Templet type);
	
	/**
	 * 根据Id查询
	 * 
	 * @param id
	 * @return
	 */
	public Templet getType(String id);
	
	
	/**
	 * 分页查询物流模板
	 * 
	 * @param t
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param cache
	 * @return
	 */
	public List<Templet> find(Templet t, String order, int currPage, int pageSize,
			boolean cache);

	/**
	 * 根据Id查询一条配送方式信息
	 * 
	 * @param id
	 * @return
	 */
	public Templet find(String id);

	/**
	 * 根据条件查询配送方式条件
	 * 
	 * @param t
	 * @return
	 */
	public int count(Templet t);

	/**
	 * 根据站点id，配送方式Id查询配送方式
	 * 
	 * @param siteid
	 * @param id
	 * @return
	 */
	public Templet get(Long siteid, String id);
	
	/**
	 * 根据站点id，配送方式Id查询配送方式
	 * 
	 * @param siteid
	 * @param id
	 * @return
	 */
	public Templet getType(Long siteid, String id);

	/**
	 * 根据站点Id查询运费模板
	 * 
	 * @param t
	 * @return
	 */
	public List<Templet> get(Templet t);

	/**
	 * 根据id删除配送方式
	 * 
	 * @param id
	 */
	public void delDeliverType(String id);

}
