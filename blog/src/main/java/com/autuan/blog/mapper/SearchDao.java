package com.autuan.blog.mapper;

import com.autuan.blog.entity.SearchItem;
import com.autuan.blog.entity.SearchResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SearchDao {
    @Autowired
    SolrClient solrClient;

    public SearchResult searchQuery(SolrQuery query) throws Exception{
        SearchResult result = new SearchResult();
        //执行查询
        QueryResponse response = solrClient.query(query);
        SolrDocumentList solrDocumentList = response.getResults();
        //获取到信息的总条数
        int totalCount = Integer.valueOf(solrDocumentList.getNumFound() +"");
        result.setTotalCount(totalCount);  //总的信息条数
        List<SearchItem> itemlist = new ArrayList<>();
        //遍历查询结果
        for (SolrDocument solrDocument : solrDocumentList) {
            SearchItem item = new SearchItem();
            //获取到高光的集合
            Map<String, Map<String,List<String>>> map = response.getHighlighting();
            List<String> list = map.get(solrDocument.get("articleId")).get("articleTitle");
            //考虑有可能查询不到的问题
            String itemTile = "";
            if(list != null && list.size() > 0){
                itemTile = list.get(0);
            } else {
                itemTile = (String) solrDocument.get("articleTitle");
            }
            //System.out.println(itemTile);
            item.setArticleTitle(itemTile);
            //---------------------------------------
            item.setArticleId((String) solrDocument.get("id"));
            item.setArticleAlertTime((String) solrDocument.get("articleAlertTime"));
            item.setArticlePublishTime((String) solrDocument.get("articlePublishTime"));
            item.setLabelName((String)solrDocument.get("labelName"));
            item.setArticleContentSub((String)solrDocument.get("articleContentSub"));
            //如果上传图片的时候有多张图片，那么解析的时候就会出现问题，我们解决方案是就取第一张
//            String image = (String) solrDocument.get("item_image");
//            if(StringUtils.isNotBlank(image)){
//                //将这个字符串切割，只要其中一个部分
//                image = image.split(",")[0];
//            }
//            item.setImage(image);
//            item.setCategory_name((String) solrDocument.get("item_category_name"));
            //添加到集合中
            itemlist.add(item);
        }
        //将list对象添加到result中
        result.setItemList(itemlist);
        return result;
    }
}
