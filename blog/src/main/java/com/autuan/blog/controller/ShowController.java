package com.autuan.blog.controller;

import com.autuan.blog.entity.Article;
import com.autuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public ModelAndView toIndex(ModelAndView mav){
        // 取文章列表
        List<Article> articles = articleService.getArticleList();
        //
        mav.addObject("articleList",articles);
        mav.addObject("tempFile","tempFile.html");
        mav.setViewName("index");
        return mav;
    }
//
//    @RequestMapping("/")
//    public ModelAndView toArticleShow(){
//
//    }
}
