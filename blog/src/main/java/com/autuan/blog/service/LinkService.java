package com.autuan.blog.service;


import com.autuan.blog.entity.Link;

public interface LinkService {

    int insertApplyLink(Link link);

    void updateLinkStatus(int linkId);
}
