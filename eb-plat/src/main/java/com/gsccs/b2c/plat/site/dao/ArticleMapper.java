package com.gsccs.b2c.plat.site.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gsccs.b2c.plat.site.model.ArticleExample;
import com.gsccs.eb.api.domain.site.Article;

public interface ArticleMapper {
	int countByExample(ArticleExample example);

	int deleteByExample(ArticleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Article record);

	int insertSelective(Article record);

	List<Article> selectByExampleWithBLOBs(ArticleExample example);

	List<Article> selectByExample(ArticleExample example);

	Article selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Article record,
			@Param("example") ArticleExample example);

	int updateByExampleWithBLOBs(@Param("record") Article record,
			@Param("example") ArticleExample example);

	int updateByExample(@Param("record") Article record,
			@Param("example") ArticleExample example);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(Article record);

	int updateByPrimaryKey(Article record);

	List<Article> selectPageByExample(ArticleExample example);
}