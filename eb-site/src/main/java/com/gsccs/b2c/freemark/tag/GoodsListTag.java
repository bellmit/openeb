package com.gsccs.b2c.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.b2c.api.service.CateServiceI;
import com.gsccs.eb.api.domain.goods.Category;

import freemarker.core.Environment;
import freemarker.ext.beans.BeanModel;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.SimpleNumber;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
/**
 * 
 * Title: GoodsListTag.java
 * 
 * Description: 类目循环标签
 * 
 * 参数
 * parid    空字符:所有;"0":一级类目;"parid":此id下类目;
 * navigation  是否导航 空字符串:所有;"1":是;"0":否;
 * state  是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值
 * category	类目对象
 * index	       索引
 * 
 * 使用示例
 * 
  <@b2c_goods_list siteid="${site.id}" ;goodslist> 
  </@b2c_goods_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("goodsListTag")
public class GoodsListTag extends BaseDirective implements TemplateDirectiveModel{
	
	@Resource
	private CateServiceI cateAPI;
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body)throws TemplateException, IOException {
		
		//获取参数
		String parid = getParam(params, "parid");// 空字符:所有;"0":一级类目;"parid":此id下类目;
		Writer out =env.getOut();
		if (body!=null) {
			//设置循环变量
			if (loopVars!=null && loopVars.length>0) {
				//查询类目
				Long parid_ = null;
				if (StringUtils.isNotEmpty(parid)){
					parid_ = Long.valueOf(parid);
				}
				
				List<Category> categoryList = null;
						//categoryService.findByPar(
						//parid_,getParam(params, "state"),getParam(params, "navigation"));
				if (categoryList!=null && categoryList.size()>0) {
					for (int i = 0; i < categoryList.size(); i++) {
						loopVars[0]=new BeanModel(categoryList.get(i),new BeansWrapper());  
						if(loopVars.length>1){
							loopVars[1]=new SimpleNumber(i);
						}
						body.render(env.getOut());  
					}
				}
			}
		}
	}


}
