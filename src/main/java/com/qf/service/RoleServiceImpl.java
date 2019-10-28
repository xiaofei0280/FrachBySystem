package com.qf.service;

import com.qf.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<String> queryAllRoleByUsername(String username) {
        Set<String> role = roleDao.findRoleByUsername(username);
        return role;
    }
}
