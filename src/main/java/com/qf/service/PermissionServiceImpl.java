package com.qf.service;


import com.qf.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements  PermissionService {

    @Autowired
    private PermissionDao permissionDao;
    @Override
    public Set<String> querypermissionByUsername(String username) {

        Set<String> permission = permissionDao.findpermissionByUsername(username);
        return  permission;

    }
}
