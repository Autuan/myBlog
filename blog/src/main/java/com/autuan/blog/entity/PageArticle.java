package com.autuan.blog.entity;

import java.util.List;

public class PageArticle {
    private List<Article> rows;
    private Integer total;

    // ========================= Getter & Setter=========================

    public List<Article> getRows() {
        return rows;
    }

    public void setRows(List<Article> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
