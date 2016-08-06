package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.deliver.Corp;
import com.gsccs.eb.api.domain.deliver.Templet;

/**
 * @说明 物流公司登记数据操作类
 * @年月日 2015年4月23日
 * @时分秒 上午9:56:02
 */
public interface DeliverServiceI {

	/**
	 * 物流公司信息保存
	 * 
	 * @param corp
	 */
	public void saveCorp(Corp corp);

	/**
	 * 根据ID查询一条物流公司信息
	 * 
	 * @param id
	 * @return
	 */
	public Corp findCorp(Integer id);

	// 分页查询所有物流公司
	List<Corp> findCorps(Corp param, int currPage, int pageSize);

	/**
	 * 查询所有配送方式
	 * 
	 * @param param
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<Templet> findTypeList(Templet param, int currPage, int pageSize);

	/**
	 * 配送方式保存
	 * 
	 * @param deliverType
	 */
	public void saveType(Templet deliverType);

	/**
	 * 根据id查询一条配送方式
	 * 
	 * @param id
	 * @return
	 */
	public Templet findType(String id);

	/**
	 * 根据ids删除配送方式
	 * 
	 * @param ids
	 */
	public void delType(String ids);

	/**
	 * 根据条件查询配送方式条数
	 * 
	 * @param param
	 * @return
	 */
	int count(Templet param);

	// 计算邮费
	public Float calculateFee(Long siteId, String dlyTypeId, String areaId,
			Integer weight);

	// 根据站点Id查询运费模板
	List<Templet> findDeliverTypes(Long siteId);

}
