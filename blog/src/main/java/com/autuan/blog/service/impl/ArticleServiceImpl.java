package com.autuan.blog.service.impl;

import com.autuan.blog.entity.Article;
import com.autuan.blog.mapper.ArticleMapper;
import com.autuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> getArticleList() {
        return articleMapper.getArticleList();
    }

    @Override
    public Article getArticleById(String articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public int insertArticle(Article article) {
        return articleMapper.insertSelective(article);
    }

    @Override
    public boolean updateArticleById(Article article) {
        int i = articleMapper.updateByPrimaryKeySelective(article);
        return i>0;
    }

    @Override
    public List<Article> getHotArticleList() {
        return articleMapper.getHotArticleList();
    }
}
