package com.autuan.blog.service;

public interface EmailService {
    /**
     * email 发送
     * @param aimAddress
     * @param sendAddress
     * @param smtpAddress
     * @param emailUsername
     * @param emailPassword
     * @param messageTitle
     * @param messageBody
     */
    void sentHtmlEmail(String[] aimAddress,String sendAddress,String smtpAddress,
              String emailUsername,String emailPassword,String messageTitle,
              String messageBody);
}
