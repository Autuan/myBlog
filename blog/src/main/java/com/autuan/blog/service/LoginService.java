package com.autuan.blog.service;

import com.autuan.blog.entity.LoginTable;

public interface LoginService {

    Integer haveThisUser(String username);

    LoginTable tryLog(String username, String password);

    int register(LoginTable newUser);

    int forgetPassword(String[] question, String[] answer);

    String getEmailAddress(String username);

    String getPhoneNumber(String username);
}
