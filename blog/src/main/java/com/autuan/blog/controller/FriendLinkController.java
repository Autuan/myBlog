package com.autuan.blog.controller;


import com.autuan.blog.config.SenderCompent;
import com.autuan.blog.entity.Link;
import com.autuan.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendLinkController {
    @Autowired
    private SenderCompent sender;
    @Autowired
    private LinkService linkService;
    // ------------------------- -------------------------
    @RequestMapping("/getLinkList")
    @GetMapping
    public List<Link> getLinkList(){
        return linkService.getLinkList();
    }

    @RequestMapping("/getLinkListOS")
    @GetMapping
    public List<Link> getLinkListOnlyShow(){
        return linkService.getLinkListOnlyShow();
    }

    @RequestMapping("/back/updateLink")
    public String updateLink(Link link){
        linkService.updateLink(link);
        return "success";
    }

    @RequestMapping("/back/deleteLink")
    public String deleteLink(Integer linkId){
        linkService.deleteLink(linkId);
        return "success";
    }

    @RequestMapping("/back/banLink")
    public String banLink(Integer linkId,Integer status){
        linkService.banLink(linkId,status);
        return "success";
    }

    @RequestMapping("/back/insertLink")
    public String insertApplyLink(Link link){
        try {
            // 检查链接
            // 向数据库添加一条申请
            linkService.insertApplyLink(link);
            // 向消息队列添加消息
            sender.sendLink(link.getLinkId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "success";
    }

}
