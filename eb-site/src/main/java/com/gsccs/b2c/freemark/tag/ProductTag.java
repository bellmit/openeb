package com.gsccs.b2c.freemark.tag;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.api.domain.Product;
import com.gsccs.b2c.web.api.service.RedisService;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * 
 * @param Title: StoreDirective.java 
 * @param Description: 店铺标签
 * 
 * @param参数 parid 空字符:所有;"par":一级类目;"parid":此id下类目; navigation 是否导航
 * 空字符串:所有;"1":是;"0":否; state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 Store 店铺对象 
 * 
 * 使用示例
 * 
 * <@b2c_store siteid="${site.id}" ;store> 
 * </@b2c_store> </p>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Service
public class ProductTag extends BaseDirective implements
		TemplateDirectiveModel {
	
	@Autowired
	private RedisService redisService;
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 店铺id
		String siteid = getParam(params, "siteid");
		String productid = getParam(params, "productid");
		
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				Product product = null;
				if (StringUtils.isNotEmpty(siteid)) {
					product = redisService.getProduct(Long.valueOf(siteid), Long.valueOf(productid));
				}
				if (product != null) {
					loopVars[0] = new BeanModel(product, new BeansWrapper());
					body.render(env.getOut());
				}
			}
		}
	}
}
