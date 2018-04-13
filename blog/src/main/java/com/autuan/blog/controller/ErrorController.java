package com.autuan.blog.controller;

import com.autuan.blog.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import javax.activation.*;
@Controller
public class ErrorController {
    @Value("${SMTP_ADDRESS}")
    private String SMTP_ADDRESS;
    @Value("${SEND_ADDRESS}")
    private String SEND_ADDRESS;
    @Value("${ERROR_AIM_ADDRESS}")
    private String ERROR_AIM_ADDRESS;
    @Value("${EMAIL_USERNAME}")
    private String EMAIL_USERNAME;
    @Value("${EMAIL_PASSWORD}")
    private String EMAIL_PASSWORD;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/errors/mail")
    @ResponseBody
    public String mail(){
        String messageTitle = "第3次邮件测试";
        String messageBody = "邮件正文<br>第二行？";
        String[] aimaddress = new String[1];
        aimaddress[0] = ERROR_AIM_ADDRESS;

        emailService.sentHtmlEmail(aimaddress,SEND_ADDRESS,SMTP_ADDRESS,
                EMAIL_USERNAME, EMAIL_PASSWORD, messageTitle,
                 messageBody);
        return "over";
    }

    @RequestMapping("/errors/test")
    @ResponseBody
    public String err(){
        int i = 10/0;
        return i+".";
    }
}
