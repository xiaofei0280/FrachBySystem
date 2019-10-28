package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    // 登录
       User  findByUsername(@Param("username") String username);

}
