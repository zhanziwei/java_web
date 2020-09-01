package com.zhanziwei.test;

import com.zhanziwei.bean.User;
import com.zhanziwei.service.UserService;
import com.zhanziwei.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void register() {
        User user = new User(null, "zzz", "zhanziwei", "111@qq.com");
        userService.register(user);
    }

    @Test
    public void login() {
        userService.login(new User());
    }

    @Test
    public void existsUserName() {
        userService.existsUserName("zzw");
    }
}