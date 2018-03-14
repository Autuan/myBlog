package com.autuan.blog.controller;

import com.autuan.blog.entity.Article;
import com.autuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    // ------------------------- -------------------------

    /**
     * 获得文章列表
     */
    @RequestMapping("/getArticleList")
    @ResponseBody
    public List<Article> getArticleList(){
        List<Article> articles = articleService.getArticleList();
        return articles;
    }

    @RequestMapping("/article/{articleId}")
    public ModelAndView getArticle(@PathVariable Integer articleId,ModelAndView mav){
        Article article = articleService.getArticleById(articleId);

        mav.addObject(article);
        mav.setViewName("articleContext");
        return mav;
    }
}
