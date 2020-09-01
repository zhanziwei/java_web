package com.zhanziwei.test;

import com.zhanziwei.bean.User;
import com.zhanziwei.dao.UserDao;
import com.zhanziwei.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUserName() {
        if (userDao.queryUserByUserName("fds") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "fdfdsfdssa", "123456", "zhanziwei@qq.com")));

    }

    @Test
    public void queryUserByUserNameAndPassword() {
        if(userDao.queryUserByUserNameAndPassword("admin", "fds") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("登录成功");
        }
    }
}