package com.autuan.blog.mapper;

import com.autuan.blog.entity.LoginTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginTableMapper {
    int deleteByPrimaryKey(Integer loginId);

    int insert(LoginTable record);

    int insertSelective(LoginTable record);

    LoginTable selectByPrimaryKey(Integer loginId);

    int updateByPrimaryKeySelective(LoginTable record);

    int updateByPrimaryKey(LoginTable record);

    Integer haveThisUser(String username);

    LoginTable tryLog(@Param("username") String username,@Param("password") String password);
}