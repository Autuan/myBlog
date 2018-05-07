package com.autuan.blog.service.impl;

import com.autuan.blog.entity.Link;
import com.autuan.blog.mapper.LinkMapper;
import com.autuan.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{
    @Autowired
    private LinkMapper linkMapper;


    @Override
    public int insertApplyLink(Link link) {
        return linkMapper.insertSelective(link);
    }

    @Override
    public void updateLinkStatus(int linkId) {
        linkMapper.updateLinkStatus(linkId);
    }
}
