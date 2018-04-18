package com.autuan.blog;

import com.autuan.blog.controller.LoginController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestComponent
public class LoginControllerTest {
    public LoginController loginController = new LoginController();

    @Test
    public void tryLog(){
//        String username = "autuan";
//        String password = "mm10086";
//        Map<String,String> map = loginController.login(username,password);
//        System.out.println(map.toString());
    }
}
