package com.autuan.blog.entity;

public class Link {
    private Integer linkId;

    private String linkName;

    private String linkUrl;

    private String linkSubcontent;

    private String linkEmail;

    private String linkQq;

    private Integer linkShow;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getLinkSubcontent() {
        return linkSubcontent;
    }

    public void setLinkSubcontent(String linkSubcontent) {
        this.linkSubcontent = linkSubcontent == null ? null : linkSubcontent.trim();
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail == null ? null : linkEmail.trim();
    }

    public String getLinkQq() {
        return linkQq;
    }

    public void setLinkQq(String linkQq) {
        this.linkQq = linkQq == null ? null : linkQq.trim();
    }

    public Integer getLinkShow() {
        return linkShow;
    }

    public void setLinkShow(Integer linkShow) {
        this.linkShow = linkShow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", linkId=").append(linkId);
        sb.append(", linkName=").append(linkName);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkSubcontent=").append(linkSubcontent);
        sb.append(", linkEmail=").append(linkEmail);
        sb.append(", linkQq=").append(linkQq);
        sb.append(", linkShow=").append(linkShow);
        sb.append("]");
        return sb.toString();
    }
}