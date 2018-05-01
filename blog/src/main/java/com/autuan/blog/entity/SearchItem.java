package com.autuan.blog.entity;

/**
 * solr 搜索的分类
 */
public class SearchItem {
    private String articleId;
    private String articleTitle;
    private String articleContentSub;
    private String articleContentSubLink;
    private String articlePublishTime;
    private String articleAlertTime;
    private String articleUrl;
    private String labelName;

    public String getArticleContentSubLink() {
        return articleContentSubLink;
    }

    public void setArticleContentSubLink(String articleContentSubLink) {
        this.articleContentSubLink = articleContentSubLink;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentSub() {
        return articleContentSub;
    }

    public void setArticleContentSub(String articleContentSub) {
        this.articleContentSub = articleContentSub;
    }

    public String getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(String articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public String getArticleAlertTime() {
        return articleAlertTime;
    }

    public void setArticleAlertTime(String articleAlertTime) {
        this.articleAlertTime = articleAlertTime;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
