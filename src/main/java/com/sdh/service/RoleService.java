package com.sdh.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/9 21:47
 * @Version 1.0
 */
public interface RoleService {
    Set<String> queryAllRolenameByUsername(@Param("username") String username);
}
