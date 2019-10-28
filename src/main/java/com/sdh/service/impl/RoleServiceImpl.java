package com.sdh.service.impl;

import com.sdh.dao.RoleDao;
import com.sdh.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/9 22:22
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    public Set<String> queryAllRolenameByUsername(String username) {
        return roleDao.queryAllRolenameByUsername(username);
    }
}
