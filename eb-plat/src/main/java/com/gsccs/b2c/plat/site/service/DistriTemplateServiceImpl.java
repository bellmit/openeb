package com.gsccs.b2c.plat.site.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.DistriTemplateMapper;
import com.gsccs.b2c.plat.site.model.DistriTemplate;

/**
 * @说明 物流费用物流模板
 * @开发者 mahong
 * @年月日 2015年4月27日
 * @时分秒 上午9:53:46
 */
@Service
public class DistriTemplateServiceImpl implements DistriTemplateService{

	@Resource
	private DistriTemplateMapper distriTemplateMapper;
	
	//保存一条物流运费模板信息
	@Override
	public void addDistriInfo(long sid, DistriTemplate template){
		distriTemplateMapper.insert(sid, template);
		System.out.println("自定义运费模板添加成功...");
	}

	//Id自增
	@Override
	public Long findMaxSId(long sid){
		Long maxId = distriTemplateMapper.selectMaxId(sid);
		if (null == maxId) {
			maxId = (long) 1;
		}
		maxId = maxId + 1;
		return maxId;
	}

}
