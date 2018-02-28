package com.autuan.blog.service;

import com.autuan.blog.entity.LoginTable;

public interface LoginService {

    Integer haveThisUser(String username);

    LoginTable tryLog(String username, String password);
}
