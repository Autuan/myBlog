package com.autuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowController {
    @RequestMapping("/")
    public ModelAndView toIndex(ModelAndView mav){
        mav.addObject("tempFile","tempFile.html");
        mav.setViewName("index");

        return mav;
    }
}
