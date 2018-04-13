package com.autuan.blog.service;

public interface EmailService {
    void sentHtmlEmail(String[] aimAddress,String sendAddress,String smtpAddress,
              String emailUsername,String emailPassword,String messageTitle,
              String messageBody);
}
