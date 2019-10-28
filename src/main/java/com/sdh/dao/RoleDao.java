package com.sdh.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName RoleDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/28 15:53
 * @Version 1.0
 */
public interface RoleDao {
    Set<String> queryAllRolenameByUsername(@Param("username") String username);
}
