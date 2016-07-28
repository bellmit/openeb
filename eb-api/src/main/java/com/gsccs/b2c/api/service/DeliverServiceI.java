package com.gsccs.b2c.api.service;

import java.util.List;

import com.gsccs.eb.api.domain.deliver.DeliverType;
import com.gsccs.eb.api.domain.deliver.DlyCorp;
import com.gsccs.eb.api.domain.deliver.DlyType;

/**
 * @说明 物流公司登记数据操作类
 * @年月日 2015年4月23日
 * @时分秒 上午9:56:02
 */
public interface DeliverServiceI {

	/**
	 * 物流公司信息保存
	 * @param corp
	 */
	public void saveDlyCorp(DlyCorp corp);

	/**
	 * 根据ID更新物流公司信息
	 * @param corp
	 */
	public void updateDlyCorp(DlyCorp corp);

	/**
	 * 根据ID查询一条物流公司信息
	 * @param id
	 * @return
	 */
	public DlyCorp findDlyCorp(Integer id);

	// 分页查询所有物流公司
	List<DlyCorp> findCorps(DlyCorp param, int currPage, int pageSize);

	// 查询所有物流公司
	List<DlyCorp> findCorps();
	
	/**
	 * 查询所有配送方式
	 * @param param
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<DeliverType> findDeliverTypeList(DeliverType param, int currPage, int pageSize);
	
	
	/**
	 * 配送方式保存
	 * @param deliverType
	 */
	public void saveDeliverType(DeliverType deliverType);

	/**
	 * 根据条件修改配送方式
	 * @param deliverType
	 */
	public void updateDeliverType(DeliverType deliverType);

	/**
	 * 根据id查询一条配送方式
	 * @param id
	 * @return
	 */
	public DeliverType findDeliverType(String id);
	
	/**
	 * 根据ids删除配送方式
	 * @param ids
	 */
	public void delDeliverType(String ids);
	
	/**
	 * 根据条件查询配送方式条数
	 * @param param
	 * @return
	 */
	int count(DeliverType param);
	
	// 计算邮费
	public Float calculateFee(Long siteId, String dlyTypeId, String areaId,
			Integer weight);
	
	// 根据站点Id查询运费模板
	List<DeliverType> findDeliverTypes(Long siteId);

}
