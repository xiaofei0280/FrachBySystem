package com.qf.service;

import com.qf.pojo.User;

public interface UserService {

  // 根据用户名查询用户信息
  User selectUserByName(String username);

}
