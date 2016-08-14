package com.gsccs.b2c.plat.site.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.b2c.plat.site.dao.ArticleMapper;
import com.gsccs.b2c.plat.site.dao.ChannelMapper;
import com.gsccs.b2c.plat.site.model.ArticleExample;
import com.gsccs.eb.api.domain.site.Article;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ChannelMapper channelMapper;

	@Override
	public void saveArticle(Article article) {
		if (null==article){
			return;
		}
		
		//默认平台文章
		if(article.getShopid()==null){
			article.setShopid(0l);
		}
		
		if (null==article.getId()) {
			article.setAddtime(new Date());
			article.setStatus(article.getStatus() == null ? "0" : article
					.getStatus());
			article.setIsrelease("0");
			articleMapper.insert(article);
			// indexArticle(content);
		}else{
			articleMapper.updateByPrimaryKeySelective(article);
		}
	}

	@Override
	public Article getArticle(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delArticle(Long id) {
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Article> find(Article content) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		return articleMapper.selectByExample(example);
	}

	@Override
	public List<Article> find(Article content, String order, int currPage,
			int pageSize) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);

		if (StringUtils.isEmpty(order)) {
			example.setOrderByClause("addtime desc");
		} else {
			example.setOrderByClause(order);
		}
		return articleMapper.selectPageByExample(example);
	}

	public void proSearchParam(Article content, ArticleExample.Criteria criteria) {
		if (null != content) {
			if (StringUtils.isNotEmpty(content.getTitle())) {
				criteria.andTitleLike("%" + content.getTitle() + "%");
			}
			if (null != content.getChannelid()) {
				criteria.andChannelEqualTo(content.getChannelid());
			}

			if (null != content.getShopid()) {
				criteria.andShopidEqualTo(content.getShopid());
			}
			
			if (StringUtils.isNotEmpty(content.getStatus())) {
				criteria.andStatusEqualTo(content.getStatus());
			}
			if (StringUtils.isNotEmpty(content.getIsrelease())) {
				criteria.andReleaseEqualTo(content.getIsrelease());
			}

			if (StringUtils.isNotEmpty(content.getIshot())) {
				criteria.andIshotEqualTo(content.getIshot());
			}

			if (StringUtils.isNotEmpty(content.getIstop())) {
				criteria.andIstopEqualTo(content.getIstop());
			}

			if (null != content.getChannelids()
					&& content.getChannelids().size() > 0) {
				criteria.andChannelIn(content.getChannelids());
			}
		}
	}

	@Override
	public int count(Article content) {
		ArticleExample example = new ArticleExample();
		ArticleExample.Criteria criteria = example.createCriteria();
		proSearchParam(content, criteria);
		return articleMapper.countByExample(example);
	}

	@Override
	public void update(Article content) {
		if (null != content) {
			articleMapper.updateByPrimaryKeySelective(content);
		}
	}

	@Override
	public void index() {
		// TODO Auto-generated method stub

	}

}