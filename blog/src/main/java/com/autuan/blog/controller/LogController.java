package com.autuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站 开发记录
 */
@Controller
@RequestMapping("/log")
public class LogController {

    // ------------------------- -------------------------

    @RequestMapping("/showLogInfo")
    public String toLogPage(){
        return "logInfo";
    }
}
