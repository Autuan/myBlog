package com.autuan.blog.config;

import com.autuan.blog.util.EmailUtil;
import com.autuan.blog.util.WebUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class DefaultExceptionHandler {
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

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest request, Exception e){
        ModelAndView mav = new ModelAndView();
        String currentTime = WebUtil.getCurrentTime();
        String messageBody = "时间:"+currentTime
                +"<br>路径是:"+request.getRequestURL()
                +"<br>信息是:"+e.toString();
        String messageTitle = "[博客错误]请尽块处理--" + currentTime;
        String[] aimaddress = new String[1];
        aimaddress[0] = ERROR_AIM_ADDRESS;

        EmailUtil.sentHtmlEmail(aimaddress,SEND_ADDRESS,SMTP_ADDRESS,
                EMAIL_USERNAME, EMAIL_PASSWORD, messageTitle,
                messageBody);

        mav.setViewName("/error/500");
        return mav;
    }
}
