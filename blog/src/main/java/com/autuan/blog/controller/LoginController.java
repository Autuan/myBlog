package com.autuan.blog.controller;

import com.autuan.blog.entity.LoginTable;
import com.autuan.blog.service.LoginService;
import com.autuan.blog.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    /*
     * 成员变量
      */
    // 用户安全管理服务接口 （ 登陆， 注册， 找回密码， ）
    @Autowired
    private LoginService loginService;

    // --------------------------------------------------

    /**
     * 登陆方法
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(String username,String password){
        // 用户和密码 合法性检查
        Map<String,String> map = LoginUtil.checkUsernameFormal(username,password);
        if ( !map.get("describe").equals("success") ) {
            return map;
        }
        // 用户名核对
        Integer num = loginService.haveThisUser(username);
        if ( num <= 0 ) {
            map.put("describe","No user");
            return map;
        }
        // 密码核对
        // 丨→字符加密
        password = LoginUtil.getSHA256Str(password);
        // 丨→验证
        LoginTable loginTable = loginService.tryLog(username,password);
        if ( null == loginTable ) {
            map.put("describe","password is error");
        // 执行登陆成功指令
        } else {
            map.put("result","success");
        }
        return map;
    }

    /**
     * 注册
     * @return
     */
    public String register(){
        return "";
    }

    /**
     * 找回密码
     * @return
     */
    public String forgetPassword(){
        return "";
    }
    // 跳转登陆页方法,test使用
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "tempFile";
    }
}
