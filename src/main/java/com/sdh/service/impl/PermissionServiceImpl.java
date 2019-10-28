package com.sdh.service.impl;

import com.sdh.dao.PermissionDao;
import com.sdh.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @ClassName PermissionServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/9 22:23
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public Set<String> queryAllPermissionByUsername(String username) {
        return permissionDao.queryAllPermissionByUsername(username);
    }
}
