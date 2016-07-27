package com.gsccs.b2c.center.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.gsccs.b2c.api.domain.EvalGoods;
import com.gsccs.b2c.api.domain.EvalOrder;
import com.gsccs.b2c.api.domain.EvalType;
import com.gsccs.b2c.api.domain.Account;
import com.gsccs.b2c.api.service.BuyerServiceI;
import com.gsccs.b2c.api.service.EvalServiceI;
import com.gsccs.b2c.api.service.OrderServiceI;
import com.gsccs.b2c.app.core.FreeMarkerUtil;
import com.gsccs.b2c.app.core.JsonMsg;
import com.gsccs.b2c.web.api.service.RedisService;
import com.gsccs.b2c.web.api.service.SsdbService;
import com.gsccs.eb.api.domain.trade.OrderItem;

import freemarker.template.TemplateModelException;

/**
 * 评价管理控制类
 * 
 * @author x.d zhang
 * 
 */
@Controller
@RequestMapping("/{site}/eval")
public class EvalController {

	@Autowired
	private EvalServiceI evalAPI;
	@Autowired
	private BuyerServiceI buyerAPI;
	@Autowired
	private OrderServiceI orderAPI;
	@Autowired
	private SsdbService ssdbService;
	@Autowired
	private RedisService redisService;

	/**
	 * 商品评价管理
	 * 
	 * @param siteId
	 * @param model
	 * @param response
	 * @return @
	 */
	@RequestMapping(value = "/list.html", method = RequestMethod.GET)
	public String evalList(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		String sitePath = redisService.getRootPath() + File.separator + siteId;
		String tempPath = "html/buyer_evals.html";

		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("store", redisService.getStore(siteId));
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			File dir = new File(sitePath);
			FreeMarkerUtil.createWriter(dir, data, tempPath,
					response.getWriter());

		} catch (TemplateModelException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray evalList(@PathVariable("site") Long siteId,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int pagesize, Model model,
			HttpServletResponse response) {
		JSONArray json = new JSONArray();
		try {
			Subject subject = SecurityUtils.getSubject();
			String account = (String) subject.getPrincipal();
			Account user = buyerAPI.findByAccount(siteId, account);
			List<OrderItem> items = orderAPI.getIsNotEvalItems(siteId,
					user.getUserId(), page, pagesize);
			if (null != items) {
				json = (JSONArray) JSON.toJSON(items);
			}
		} catch (Exception e) {

		}
		return json;
	}

	/**
	 * 请问评价项类型
	 * 
	 * @param siteId
	 * @param model
	 * @return @
	 */
	@RequestMapping(value = "/typelist", method = RequestMethod.POST)
	@ResponseBody
	public JSONArray evalType(@PathVariable("site") Long siteId, Model model,
			HttpServletResponse response) {
		EvalType evalType = new EvalType();

		List<EvalType> evalTypes = evalAPI.evalTypeList(evalType);
		JSONArray array = (JSONArray) JSON.toJSON(evalTypes);
		return array;
	}

	/**
	 * 添加评价
	 * 
	 * @param siteId
	 * @param request
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public JsonMsg addeval(@PathVariable("site") Long siteId,
			Long productid,String scores,String remark,HttpServletRequest request) {
		JsonMsg json = new JsonMsg();
		Subject subject = SecurityUtils.getSubject();
		String username = (String) subject.getPrincipal();
		try {
			Account user = buyerAPI.findByAccount(siteId, username);
			Long buyerid = user.getUserId();
			List<EvalOrder> evalscoreList= new ArrayList<EvalOrder>();
			if (null != productid){
				if (StringUtils.isNotEmpty(scores)){
					String[] itemScores = scores.split(";");
					if (null != itemScores && itemScores.length>0){
						
						for(int i=0;i<itemScores.length;i++){
							EvalOrder evalscore = new EvalOrder();
							if (StringUtils.isNotEmpty(itemScores[i]) ){
								String[] itemscore = itemScores[i].split(":");
								if (null != itemscore && itemscore.length>1){
									Integer score= Integer.valueOf(itemscore[1]);
									Long itemId = Long.valueOf(itemscore[0]);
									evalscore.setProductid(productid);
									evalscore.setUserid(buyerid);
									evalscore.setScore(score);
									evalscore.setItemId(itemId);
									evalscoreList.add(evalscore);
								}
							}
						}
					}
				}
				
				EvalGoods detail = new EvalGoods();
				detail.setContent(remark);
				detail.setProductid(productid);
				detail.setUserid(buyerid);
				detail.setSiteid(siteId);
				evalAPI.addEvalScores(siteId,evalscoreList,detail);
			}
			
			json.setSuccess(true);
			json.setMsg("评价成功!");
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("评价失败!");
		}
		return json;
	}
}
