package com.qf.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface PermissionDao {

   Set<String>  findpermissionByUsername(@Param("username") String username);

}
