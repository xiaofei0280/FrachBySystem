package com.qf.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleService {

     Set<String> queryAllRoleByUsername(@Param("username") String username);
}
