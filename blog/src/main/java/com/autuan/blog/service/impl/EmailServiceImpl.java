package com.autuan.blog.service.impl;

import com.autuan.blog.service.EmailService;
import com.autuan.blog.util.EmailUtil;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sentHtmlEmail(String[] aimAddress, String sendAddress, String smtpAddress, String emailUsername, String emailPassword, String messageTitle, String messageBody) {
        EmailUtil.sentHtmlEmail(aimAddress,sendAddress,smtpAddress,emailUsername,emailPassword,messageTitle,messageBody);
    }
}
