package com.autuan.blog.mapper;

import com.autuan.blog.entity.Article;
import com.autuan.blog.entity.Label;
import com.autuan.blog.entity.SearchItem;
import com.autuan.blog.entity.SearchResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SearchMapper {
    List<SearchItem> selectSearchItem();

}
