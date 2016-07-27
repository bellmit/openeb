package com.gsccs.b2c.plat.site.service;

import java.util.List;

import com.gsccs.b2c.plat.site.model.DeliverCorpT;
import com.gsccs.b2c.plat.site.model.DeliverTypeT;

/**
 * @说明 商品货运物流接口 快递物流订单查询服务比如申通快递、顺丰快递、圆通快递、EMS快递、汇通快递、宅急送快递等
 * @开发者 ma hong
 * @年月日 2015年4月13日
 * @时分秒 上午9:33:36
 */
public interface DeliverService {

	// 物流公司信息保存
	public void saveDeliver(DeliverCorpT deliverCorpT);

	// 根据ID更新物流公司信息
	public void updateDeliver(DeliverCorpT deliverCorpT);

	// 根据ID删除物流公司信息
	public void delete(Integer id);

	// 根据ID查询一条物流公司信息
	public DeliverCorpT find(Integer id);

	/**
	 * 分页查询物流公司信息
	 * @param t
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param cache
	 * @return
	 */
	public List<DeliverCorpT> find(DeliverCorpT t, String order, int currPage,
			int pageSize, boolean cache);
	
	/**
	 * 查询所有的物流信息
	 * @param t
	 * @return
	 */
	public List<DeliverCorpT> findAllDeliverCorpt();
	/**
	 * 根据条件查询物流公司信息条数
	 * @param t
	 * @return
	 */
	public int count(DeliverCorpT t);

	
	/**
	 * 保存配送方式
	 * @param deliverCorpT
	 */
	public void saveDeliverTypeT(DeliverTypeT deliverCorpT);

	/**
	 * 根据Id更新配送方式
	 * @param deliverCorpT
	 */
	public void updateDeliverTypeT(DeliverTypeT deliverCorpT);


	/**
	 *  根据Id查询一条配送方式信息
	 * @param id
	 * @return
	 */
	public DeliverTypeT find(String  id);
	
	
	/**
	 * 分页查询配送方式信息
	 * @param t
	 * @param order
	 * @param currPage
	 * @param pageSize
	 * @param cache
	 * @return
	 */
	public List<DeliverTypeT> find(DeliverTypeT t, String order, int currPage,
			int pageSize, boolean cache);
	/**
	 * 根据条件查询配送方式条件
	 * @param t
	 * @return
	 */
	public int count(DeliverTypeT t);
	
	/**
	 * 根据站点id，配送方式Id查询配送方式
	 * @param siteid
	 * @param id
	 * @return
	 */
	public DeliverTypeT get(Long siteid,String id);
	
	/**
	 * 根据站点Id查询运费模板
	 * @param t
	 * @return
	 */
	public List<DeliverTypeT> get(DeliverTypeT t);
	/**
	 * 根据id删除配送方式
	 * @param id
	 */
	public void delDeliverType(String id);

}
