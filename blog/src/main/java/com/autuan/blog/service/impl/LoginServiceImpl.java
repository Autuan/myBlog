package com.autuan.blog.service.impl;

import com.autuan.blog.entity.LoginTable;
import com.autuan.blog.mapper.LoginTableMapper;
import com.autuan.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginTableMapper loginTableMapper;
    @Override
    public Integer haveThisUser(String username) {
        return loginTableMapper.haveThisUser(username);
    }

    @Override
    public LoginTable tryLog(String username, String password) {
        return loginTableMapper.tryLog(username,password);
    }

    @Override
    public int register(LoginTable newUser) {
        return loginTableMapper.insertSelective(newUser);
    }

    @Override
    public int forgetPassword(String[] question, String[] answer) {
        return 0;
    }

    @Override
    public String getEmailAddress(String username) {
        return null;
    }

    @Override
    public String getPhoneNumber(String username) {
        return null;
    }
}
