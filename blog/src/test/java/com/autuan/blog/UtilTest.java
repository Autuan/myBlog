package com.autuan.blog;

import com.autuan.blog.config.SenderCompent;
import com.autuan.blog.util.LoginUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilTest {
    @Autowired
    private SenderCompent send;


    @Test
    public void test1(){
        String username = "abc123";
        String password = "12345";
        Map map = LoginUtil.checkUsernameFormal(username,password);
        System.out.println(map.toString());
    }

    @Test
    public void testSend(){
        send.send();
    }
}
