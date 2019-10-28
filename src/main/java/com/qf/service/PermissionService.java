package com.qf.service;

import java.util.Set;

public interface PermissionService {
    Set<String> querypermissionByUsername(String username);

}
