package com.autuan.blog.entity;

public class Article {
    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private String articleContentSub;

    private String articleContentSubLink;

    private String articlePublishTime;

    private String articleAlertTime;

    private Integer articleCountView;

    private Integer articleCountAgree;

    private Integer articleHot;

    private String articleUrl;

    private Integer labelId;

    private Integer articleStatus;

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    public String getArticleContentSub() {
        return articleContentSub;
    }

    public void setArticleContentSub(String articleContentSub) {
        this.articleContentSub = articleContentSub == null ? null : articleContentSub.trim();
    }

    public String getArticleContentSubLink() {
        return articleContentSubLink;
    }

    public void setArticleContentSubLink(String articleContentSubLink) {
        this.articleContentSubLink = articleContentSubLink == null ? null : articleContentSubLink.trim();
    }

    public String getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(String articlePublishTime) {
        this.articlePublishTime = articlePublishTime == null ? null : articlePublishTime.trim();
    }

    public String getArticleAlertTime() {
        return articleAlertTime;
    }

    public void setArticleAlertTime(String articleAlertTime) {
        this.articleAlertTime = articleAlertTime == null ? null : articleAlertTime.trim();
    }

    public Integer getArticleCountView() {
        return articleCountView;
    }

    public void setArticleCountView(Integer articleCountView) {
        this.articleCountView = articleCountView;
    }

    public Integer getArticleCountAgree() {
        return articleCountAgree;
    }

    public void setArticleCountAgree(Integer articleCountAgree) {
        this.articleCountAgree = articleCountAgree;
    }

    public Integer getArticleHot() {
        return articleHot;
    }

    public void setArticleHot(Integer articleHot) {
        this.articleHot = articleHot;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl == null ? null : articleUrl.trim();
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleId=").append(articleId);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", articleContentSub=").append(articleContentSub);
        sb.append(", articleContentSubLink=").append(articleContentSubLink);
        sb.append(", articlePublishTime=").append(articlePublishTime);
        sb.append(", articleAlertTime=").append(articleAlertTime);
        sb.append(", articleCountView=").append(articleCountView);
        sb.append(", articleCountAgree=").append(articleCountAgree);
        sb.append(", articleHot=").append(articleHot);
        sb.append(", articleUrl=").append(articleUrl);
        sb.append(", labelId=").append(labelId);
        sb.append("]");
        return sb.toString();
    }
}