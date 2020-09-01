package com.zhanziwei.service.impl;

import com.zhanziwei.bean.User;
import com.zhanziwei.dao.UserDao;
import com.zhanziwei.dao.impl.UserDaoImpl;
import com.zhanziwei.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUserName(String userName) {
        return userDao.queryUserByUserName(userName) != null;
    }
}
