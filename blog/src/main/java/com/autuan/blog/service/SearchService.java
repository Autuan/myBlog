package com.autuan.blog.service;

import com.autuan.blog.entity.SearchResult;

public interface SearchService {
    /**
     * 搜索服务
     * @param query 关键字
     * @param page 第n页
     * @param page_size 每页条数
     * @return
     */
    SearchResult getSearchResult(String query, int page, Integer page_size);

    /**
     * 导入信息到solr库中
     */
    void selectArticleToSolr();
}
