package com.gsccs.b2c.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.api.exception.ApiException;
import com.gsccs.b2c.solr.service.SolrService;

/**
 * 自动补全查询
 * @author x.d zhang
 *
 */
@Controller
public class SuggestController {

	/**
	 * 自动补全
	 * @param siteId
	 * @param response
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/{site}/suggest")
	public List<String> suggest(@PathVariable("site") Long siteId, Model model,
			String q,String keywords,HttpServletResponse response) throws ApiException {
		System.out.println("suggest keywords:"+keywords);
		System.out.println("suggest q:"+q);
		SolrService solrS = new SolrService();
		solrS.init();
		return solrS.suggest(keywords);
	}

}
