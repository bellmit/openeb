package com.gsccs.b2c.freemark.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gsccs.b2c.api.domain.Order;
import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.web.api.service.SsdbService;

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
 * Title: OrderListTag.java
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
  <@b2c_order_list siteid="${site.id}" state="";goodslist> 
  </@b2c_order_list>
 * 
 * @author x.d zhang
 * @version 1.0
 * 
 */
@Component("orderListTag")
public class OrderListTag extends BaseDirective implements TemplateDirectiveModel{
	
	@Resource
	private OrderServiceI orderAPI;
	@Resource
	private SsdbService ssdbService;
	
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body)throws TemplateException, IOException {
		//获取参数
		String siteid = getParam(params, "siteid");
		//状态
		String state = getParam(params, "state");
		if (body!=null) {
			//设置循环变量
			if (loopVars!=null && loopVars.length>0) {
				//查询类目
				Long siteId = null;
				if (StringUtils.isNotEmpty(siteid)){
					siteId = Long.valueOf(siteid);
				}
				Order param = new Order();
				//param.setState(state);
				List<Order> orders = null;
				try {
					orders = orderAPI.getOrderList(siteId, param, "", 1, Integer.MAX_VALUE);
				} catch (ApiException e) {
					e.printStackTrace();
				}
				if (orders!=null && orders.size()>0) {
					for (int i = 0; i < orders.size(); i++) {
						loopVars[0]=new BeanModel(orders.get(i),new BeansWrapper());  
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
