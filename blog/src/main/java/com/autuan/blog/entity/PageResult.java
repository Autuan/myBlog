package com.autuan.blog.entity;

import java.util.List;

public class PageResult {
    private List<?> rows;
    private Integer total;

    // ========================= Getter & Setter=========================

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
