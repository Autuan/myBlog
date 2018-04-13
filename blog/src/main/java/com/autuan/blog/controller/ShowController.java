package com.autuan.blog.controller;

import com.autuan.blog.entity.Article;
import com.autuan.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        // 取热点列表（置顶）
        List<Article> hotArticles = articleService.getHotArticleList();
        //
        mav.addObject("articleList",articles);
        mav.addObject("hotList",hotArticles);
        mav.addObject("tempFile","tempFile.html");
        mav.setViewName("blogIndex");
        return mav;
    }
//
//    @RequestMapping("/")
//    public ModelAndView toArticleShow(){
//
//    }

    @RequestMapping("/back/")
    public String toBackIndex(){
        return "index";
    }

    @RequestMapping("/back/getArticleList")
    @ResponseBody
    public List<Article> getArticleList(){
        List<Article> articles = articleService.getArticleList();
        return articles;
    }

    @RequestMapping("/back/{path}")
    public ModelAndView toBackPart(@PathVariable String path, ModelAndView mav){
        // return "back/" + path;
        switch (path) {
            case "visitor" :break;
            case "web" :break;
            case "blog" :break;
            case "newBlog" :
                mav.addObject("appTitle","新增博客");
                mav.addObject("appContent","记录好心情");
                mav.addObject("appUrl",path);
                break;
            case "blogList" :
                mav.addObject("appTitle","博客列表");
                mav.addObject("appContent","服务器记录的博客列表");
                mav.addObject("appUrl",path);
                break;
            default:break;
        }
        mav.setViewName("back/" + path);
        return mav;
    }
}
