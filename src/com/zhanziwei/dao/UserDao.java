package com.zhanziwei.dao;

import com.zhanziwei.bean.User;

public interface UserDao {
    public User queryUserByUserName(String username);
    public int saveUser(User user);
    public User queryUserByUserNameAndPassword(String username, String password);
}
