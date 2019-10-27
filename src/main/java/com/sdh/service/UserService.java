package com.sdh.service;

import com.sdh.pojo.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 16:53
 * @Version 1.0
 */
public interface UserService {
    /**
     * todo: 根据用户名获取该用户的信息
     * @param username
     * @return
     */
    User queryUserByUsername(String username);

}
