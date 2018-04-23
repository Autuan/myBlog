package com.autuan.blog.service.impl;

import com.autuan.blog.entity.Article;
import com.autuan.blog.entity.Label;
import com.autuan.blog.entity.SearchItem;
import com.autuan.blog.entity.SearchResult;
import com.autuan.blog.mapper.SearchDao;
import com.autuan.blog.mapper.SearchMapper;
import com.autuan.blog.service.SearchService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SolrClient solrClient;
    @Autowired
    SearchDao searchDao;
    @Autowired
    SearchMapper searchMapper;

    @Override
    public SearchResult getSearchResult(String queryString, int page, Integer rows) {
        SolrQuery query = new SolrQuery();
        query.setQuery(queryString);
        //设置分页信息
        //(当前页 - 1)*每页显示的信息条数
        if(page < 1) page = 1;
        query.setStart((page - 1)*rows);
        if(rows < 1) rows = 20;
        query.setRows(rows);

        //设置搜索域(默认域)--默认查询的是商品的标题
        query.set("df", "articleTitle");
        //设置高光
        query.setHighlight(true);
        //设置高光显示的具体的域
        query.addHighlightField("articleTitle");
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");
        SearchResult result = null;
        try {
            result = searchDao.searchQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //计算有多少页
        int totalPage = result.getTotalCount() / rows;
        if(result.getTotalCount() % rows != 0){
            totalPage++;
        }
        result.setTotalPage(totalPage);
        return result;
    }

    @Override
    public void selectArticleToSolr() {

        List<SearchItem> list = searchMapper.selectSearchItem();
        list.forEach(article -> {
            try {
                SolrInputDocument doc = new SolrInputDocument();
                doc.setField("articleId",article.getArticleId());
                doc.setField("id",article.getArticleId());
                doc.setField("articleTitle",article.getArticleTitle());
                doc.setField("articleContentSub",article.getArticleContentSub());
                doc.setField("articlePublishTime",article.getArticlePublishTime());
                doc.setField("articleAlertTime",article.getArticleAlertTime());
                solrClient.add(doc);
            } catch (SolrServerException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });

        try {
            solrClient.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
