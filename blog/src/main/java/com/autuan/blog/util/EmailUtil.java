package com.autuan.blog.util;

import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
/**
 * 电子邮件工具类
 * 服务器端需要开放smtp服务
 * 需要用到的jar：
 * <groupId>javax.mail</groupId>
 * <artifactId>mail</artifactId>
 * @author autuan.yu
 */
public class EmailUtil {
    /**
     * email一段信息
     * @param aimAddress 收件人电子邮箱
     * @param sendAddress 发件人电子邮箱
     * @param smtpAddress smtp主机地址
     * @param emailUsername 发送邮箱详细名：example@example.com
     * @param emailPassword 发送邮箱密码
     * @param messageTitle 邮件标题
     * @param messageBody 邮件正文
     */
    public static void sendEmail(String[] aimAddress,String sendAddress,String smtpAddress,
                                 String emailUsername,String emailPassword,String messageTitle,
                                 String messageBody){
        try{
        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", smtpAddress);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                //发件人邮件用户名、密码
                return new PasswordAuthentication(emailUsername, emailPassword);
            }
        });
            InternetAddress[] address=new InternetAddress[aimAddress.length];
            for (int i = 0; i < aimAddress.length; i++) {
                address[i]=new InternetAddress(aimAddress[i]);
            }
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(sendAddress));

            // Set To: 头部头字段
            message.addRecipients(Message.RecipientType.TO,
                    address);

            // Set Subject: 头部头字段
            message.setSubject(messageTitle);

            // 设置消息体
            message.setText(messageBody);

            // 发送消息
            Transport.send(message);

        // Messaging Error处理
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void sentHtmlEmail(String[] aimAddress,String sendAddress,String smtpAddress,
                                     String emailUsername,String emailPassword,String messageTitle,
                                     String messageBody){
        try{
            // 获取系统属性
            Properties properties = System.getProperties();

            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", smtpAddress);
            properties.put("mail.smtp.auth", "true");
            // 获取默认session对象
            Session session = Session.getDefaultInstance(properties,new Authenticator(){
                public PasswordAuthentication getPasswordAuthentication()
                {
                    //发件人邮件用户名、密码
                    return new PasswordAuthentication(emailUsername, emailPassword);
                }
            });
            InternetAddress[] address=new InternetAddress[aimAddress.length];
            for (int i = 0; i < aimAddress.length; i++) {
                address[i]=new InternetAddress(aimAddress[i]);
            }
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(sendAddress));

            // Set To: 头部头字段
            message.addRecipients(Message.RecipientType.TO,
                    address);

            // Set Subject: 头部头字段
            message.setSubject(messageTitle);

            // 设置消息体
            message.setContent(messageBody,"text/html; charset=utf-8");

            // 发送消息
            Transport.send(message);

            // Messaging Error处理
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    public static void sentAnnexEmail(String[] aimAddress, String sendAddress, String smtpAddress,
                                      String emailUsername, String emailPassword, String messageTitle,
                                      BodyPart messageBody, File file){
        try{
            // 获取系统属性
            Properties properties = System.getProperties();

            // 设置邮件服务器
            properties.setProperty("mail.smtp.host", smtpAddress);
            properties.put("mail.smtp.auth", "true");
            // 获取默认session对象
            Session session = Session.getDefaultInstance(properties,new Authenticator(){
                public PasswordAuthentication getPasswordAuthentication()
                {
                    //发件人邮件用户名、密码
                    return new PasswordAuthentication(emailUsername, emailPassword);
                }
            });
            InternetAddress[] address=new InternetAddress[aimAddress.length];
            for (int i = 0; i < aimAddress.length; i++) {
                address[i]=new InternetAddress(aimAddress[i]);
            }
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(sendAddress));

            // Set To: 头部头字段
            message.addRecipients(Message.RecipientType.TO,
                    address);

            // Set Subject: 头部头字段
            message.setSubject(messageTitle);

            Multipart multipart = new MimeMultipart();
            // 设置文本消息
            multipart.addBodyPart(messageBody);
            // 设置符件消息
            messageBody = new MimeBodyPart();
            DataSource dataSource = (DataSource) new FileDataSource(file.getCanonicalPath());
            messageBody.setDataHandler(new DataHandler((javax.activation.DataSource) dataSource));
            messageBody.setFileName(file.getName());
            multipart.addBodyPart(messageBody);

            message.setContent(multipart);
            // 发送消息
            Transport.send(message);

            // Messaging Error处理
        }catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
