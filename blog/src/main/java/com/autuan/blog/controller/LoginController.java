package com.autuan.blog.controller;

import com.autuan.blog.entity.LoginTable;
import com.autuan.blog.service.LoginService;
import com.autuan.blog.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public Map<String,String> login(String username, String password, HttpServletRequest request){
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
        // 丨→保存 session 在服务器
            HttpSession session = request.getSession();
            session.setAttribute(loginTable.getLoginName(),loginTable);
            // 时间设置
            session.setMaxInactiveInterval(60);
        } else {
            map.put("result","success");
        }
        return map;
    }

    /**
     * 注册
     * @return
     */
    public Map<String,String> register(String username,String password){
        // 判断输入的合法性
        Map<String,String> map = LoginUtil.checkUsernameFormal(username,password);
        if ( !map.get("describe").equals("success") ) {
            return map;
        }
        // 用户名核对
        Integer num = loginService.haveThisUser(username);
        if ( num == 1 ) {
            map.put("describe","This username already existed");
            return map;
        }
        // 字符加密
        password = LoginUtil.getSHA256Str(password);
        LoginTable newUser = new LoginTable();
        newUser.setLoginName(username);
        newUser.setLoginPassword(password);
        int result = loginService.register(newUser);
        if (result > 1) {
            map.put("result","success");
        } else {
            map.put("describe","unknow error , try again later please");
        }
        return map;
    }

    /**
     * 找回密码
     * @return
     */
    // 密保验证
    public String forgetPassword(String question[],String answer[]){
        // 验证
        int result = loginService.forgetPassword(question,answer);
        if (result == 1) {
            return "success";
        } else {
            return "error";
        }
    }
    // 邮箱验证
    public String forgetPasswordByEmail(String username){
        // 查询邮箱
        String emailAddress = loginService.getEmailAddress(username);
        // 调用邮箱接口
        // 返回结果
        return "success";
    }
    // 手机验证
    public String forgetPasswordByPhone(String username) {
        // 查询手机号
        String phoneNumber = loginService.getPhoneNumber(username);
        // 调用邮箱接口
        // 返回结果
        return "success";
    }
    // 修改密码
    public void changePassword(String username , String password) {
        return;
    }

    // 跳转登陆页方法,test使用
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "tempFile";
    }
}
