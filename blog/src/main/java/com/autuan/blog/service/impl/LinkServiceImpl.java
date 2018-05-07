package com.autuan.blog.service.impl;

import com.autuan.blog.entity.Link;
import com.autuan.blog.mapper.LinkMapper;
import com.autuan.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService{
    @Autowired
    private LinkMapper linkMapper;


    @Override
    public int insertApplyLink(Link link) {
        return linkMapper.insertSelective(link);
    }

    @Override
    public List<Link> getLinkList() {
        return linkMapper.getLinkList();
    }

    @Override
    public void updateLink(Link link) {
        linkMapper.updateByPrimaryKeySelective(link);
    }

    @Override
    public void deleteLink(Integer linkId) {
        linkMapper.deleteByPrimaryKey(linkId);
    }

    @Override
    public void banLink(Integer linkId, Integer status) {
        linkMapper.banLink(linkId,status);
    }

    @Override
    public List<Link> getLinkListOnlyShow() {
        return linkMapper.getLinkListOnlyShow();
    }
}
