package com.autuan.blog;

import com.autuan.blog.util.LoginUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@TestComponent
public class UtilTest {

    @Test
    public void test1(){
        String username = "abc123";
        String password = "12345";
        Map map = LoginUtil.checkUsernameFormal(username,password);
        System.out.println(map.toString());
    }
}
