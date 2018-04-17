package com.autuan.blog.controller;

import com.autuan.blog.entity.Article;
import com.autuan.blog.entity.PageArticle;
import com.autuan.blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShowController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public ModelAndView toIndex(@RequestParam(defaultValue = "1",value = "pageNumber") Integer page,
                                @RequestParam(defaultValue = "5",value = "pageSize") Integer rows,ModelAndView mav){


        // 取热点列表（置顶）
        List<Article> hotArticles = articleService.getHotArticleList();
        //
        PageHelper.startPage(page,rows);
        // 取文章列表
        List<Article> articles = articleService.getArticleList();
        PageInfo<Article> pageInfo = new PageInfo<>(articles);

        int totalCounts = (int) pageInfo.getTotal();

        int totalPages = totalCounts/rows;
        totalPages += totalCounts%rows==0 ? 0 : 1;

        mav.addObject("articleList",articles);
        mav.addObject("hotList",hotArticles);

        mav.addObject("currentPage",page);
        mav.addObject("totalPages",totalPages);
        mav.addObject("pageSize","5");
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
