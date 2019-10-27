package com.sdh.test;

import com.sdh.dao.UserDao;
import com.sdh.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName DaoTest
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/26 16:50
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testDao(){
        User admin = userDao.queryUserByUsername("admin");
        System.out.println(admin);
    }


}
