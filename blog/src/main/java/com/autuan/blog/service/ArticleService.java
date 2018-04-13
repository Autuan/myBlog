package com.autuan.blog.service;

import com.autuan.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 取文章列表
     * @return
     */
    List<Article> getArticleList();

    /**
     * 根据id取指定文章
     * @param articleId id
     * @return
     */
    Article getArticleById(String articleId);

    /**
     * 新增文章
     * @param article 要新增的文章
     * @return
     */
    int insertArticle(Article article);

    /**
     * 根据id修改文章
     * @param article
     * @return
     */
    boolean updateArticleById(Article article);

    /**
     * 取热点列表
     * @return
     */
    List<Article> getHotArticleList();
}
