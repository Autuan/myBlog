package com.autuan.blog.controller;

import com.autuan.blog.entity.Article;
import com.autuan.blog.service.ArticleService;
import com.autuan.blog.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static java.lang.Math.*;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Value("${ARTICLE_PREFIX}")
    private String url;
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
    public ModelAndView getArticle(@PathVariable String articleId,ModelAndView mav){
        Article article = articleService.getArticleById(articleId);
        // 进行访问数据记录 ( 功能未做 )
        mav.addObject(article);
        mav.setViewName("articleContext");
        return mav;
    }

    /**
     *
     * @param article 有 标题\内容简介\置顶\分类\内容
     * @return 结果
     */
    @ResponseBody
    @RequestMapping("/article/insertArticle")
    public String insertArticle(Article article) {
        // 生成文章其他所需要的信息
        //  |__生成主键
            String articleId = WebUtil.getCurrentTimeNoMark();
            article.setArticleId(WebUtil.getCurrentTimeNoMark());
        //  |__ 发布 & 修改 时间
            String currentTime = WebUtil.getCurrentTime();
            article.setArticleAlertTime(currentTime);
            article.setArticlePublishTime(currentTime);
        //  |__ 修改文章链接
            article.setArticleUrl(url+articleId);

        // 数据库添加
        int id = articleService.insertArticle(article);
        if ( id > 0 ) {
            return "success";
        }
        return "error";
    }
}
