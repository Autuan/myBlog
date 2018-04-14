package com.autuan.blog.entity;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{
	private List<?> itemList;	//根据搜索条件查询到的集合
	private Integer totalCount;			//总的信息条数
	private Integer totalPage;			//总的页数
	public List<?> getItemList() {
		return itemList;
	}
	public void setItemList(List<?> itemList) {
		this.itemList = itemList;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
}
