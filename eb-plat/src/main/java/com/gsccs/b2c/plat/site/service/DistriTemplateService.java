package com.gsccs.b2c.plat.site.service;

import com.gsccs.b2c.plat.site.model.DistriTemplate;

/**
 * @说明     物流费用物流模板
 * @开发者 mahong
 * @年月日 2015年4月27日
 * @时分秒 上午9:39:38
 */
public interface DistriTemplateService{
	
	/*=======================ID自增===============================*/
	public Long findMaxSId(long sid);

	//保存一条物流运费模板信息
	public void addDistriInfo(long sid,DistriTemplate template);
	
	
}
