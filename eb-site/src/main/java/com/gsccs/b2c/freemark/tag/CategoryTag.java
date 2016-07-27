package com.gsccs.b2c.freemark.tag;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.b2c.api.domain.Category;
import com.gsccs.b2c.api.service.CateServiceI;

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
 * Title: CategoryDirective.java Description: 类目标签
 * 
 * 参数 parid 空字符:所有;"par":一级类目;"parid":此id下类目; navigation 是否导航
 * 空字符串:所有;"1":是;"0":否; state 是否有效 空字符串:所有;"1":是;"0":否;
 * 
 * 返回值 category 类目对象 index 索引
 * 
 * 使用示例
 * 
 * <@shop_category siteid="${site.id}" ;category> <td class="index_menu index_menu_jg">
 * |</td> <td class="index_menu index_menu1"><a href="#">${category.name}</a></td>
 * </@shop_category> </p>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("cateTag")
public class CategoryTag extends BaseDirective implements
		TemplateDirectiveModel {

	@Resource
	private CateServiceI cateAPI;

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		// 栏目id
		String categoryid = getParam(params, "id");
		
		if (body != null) {
			// 设置循环变量
			if (loopVars != null && loopVars.length > 0) {
				// 查询类目
				Category category = null;
				// 有categoryid参数则根据categoryid参数查询
				if (StringUtils.isNotEmpty(categoryid)) {
					category = cateAPI.getCate(Long.valueOf(categoryid));
				}

				if (category != null) {
					loopVars[0] = new BeanModel(category, new BeansWrapper());
					body.render(env.getOut());
				}
			}
		}
	}
}
