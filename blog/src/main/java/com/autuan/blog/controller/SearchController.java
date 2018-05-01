package com.autuan.blog.controller;

import com.autuan.blog.entity.SearchResult;
import com.autuan.blog.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    // ========================= =========================
    @Value("10")
    private Integer PAGE_SIZE;

    // ========================= =========================
    @RequestMapping("/search")
    public String searchIndex(@RequestParam("q") String query,
                              @RequestParam(defaultValue = "1") int page, Model model) throws Exception{
        SearchResult result = searchService.getSearchResult(query,page,PAGE_SIZE);
        //数据回显
        model.addAttribute("query", query);
        model.addAttribute("pageSize", PAGE_SIZE);
        model.addAttribute("articleList", result.getItemList());		//查询到的商品集合(从dao层查询)
        model.addAttribute("totalPages", result.getTotalPage());	//总的页数(获取到总的信息条数，然后根据每页显示屏的信息条数进行计算)
        model.addAttribute("currentPage", page);			//当前的页码(翻页)
        return "search";
    }

    @RequestMapping("/selectToSolr")
    @ResponseBody
    public String selectToSolr(){
        String returnString = "success";
        try{
            searchService.selectArticleToSolr();
        } catch (Exception e) {
            returnString = "error";
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return returnString;
    }
}
