package com.sdh.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName PermissionDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/9 21:47
 * @Version 1.0
 */
public interface PermissionDao {
    Set<String> queryAllPermissionByUsername(@Param("username") String username);
}
