package com.sdh.dao;

import com.sdh.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 16:42
 * @Version 1.0
 */
public interface UserDao {

    User queryUserByUsername(@Param("username") String username);

}
