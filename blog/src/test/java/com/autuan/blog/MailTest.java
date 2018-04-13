package com.autuan.blog;

import com.autuan.blog.controller.ErrorController;
import com.autuan.blog.util.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class MailTest {
  ErrorController errorController = new ErrorController();

  @Test
  public void testMail(){
      errorController.mail();
  }

  @Test
  public void testMail2(){
      String smtpAddress="smtp.mxhichina.com";
      String sendAddress="autuan@autuan.cn";
      String ERROR_AIM_ADDRESS="autuan.yu@gmail.com";
      String emailUsername="autuan@autuan.cn";
      String emailPassword="Wanc0301";
      String messageTitle = "第3次邮件测试";
      String messageBody = "邮件正文<br>第二行？";
      String[] aimAddress = new String[1];
      aimAddress[0] = ERROR_AIM_ADDRESS;

      EmailUtil.sentHtmlEmail(aimAddress,sendAddress,smtpAddress,emailUsername,emailPassword,messageTitle,messageBody);
      System.out.println("========================= email over =========================");
  }
}
