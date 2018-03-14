package com.autuan.blog.service;

import com.autuan.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getArticleList();

    Article getArticleById(Integer articleId);
}
