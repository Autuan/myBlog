package com.autuan.blog.service;


import com.autuan.blog.entity.Link;

import java.util.List;

public interface LinkService {

    int insertApplyLink(Link link);

    List<Link> getLinkList();

    void updateLink(Link link);

    void deleteLink(Integer linkId);

    void banLink(Integer linkId, Integer status);

    List<Link> getLinkListOnlyShow();
}
