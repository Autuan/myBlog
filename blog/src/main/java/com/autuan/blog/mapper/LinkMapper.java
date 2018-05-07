package com.autuan.blog.mapper;

import com.autuan.blog.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@Mapper
public interface LinkMapper {
    int deleteByPrimaryKey(Integer linkId);

    int insert(Link record);

    int insertSelective(Link record);

    Link selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(Link record);

    int updateByPrimaryKey(Link record);

    List<Link> getLinkList();

    void banLink(@RequestParam("linkId") Integer linkId,
                 @RequestParam("status") Integer status);

    List<Link> getLinkListOnlyShow();
}