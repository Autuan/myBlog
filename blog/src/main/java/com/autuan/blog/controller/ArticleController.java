package com.autuan.blog.controller;

import com.autuan.blog.entity.Article;
import com.autuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    // ------------------------- -------------------------

    /**
     * 获得文章列表
     */
    @RequestMapping("/getArticleList")
    public List<Article> getArticleList(){
        List<Article> articles = articleService.getArticleList();
        return articles;
    }

}
