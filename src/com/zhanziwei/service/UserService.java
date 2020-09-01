package com.zhanziwei.service;

import com.zhanziwei.bean.User;

public interface UserService {
    public void register(User user);
    public User login(User user);
    public boolean existsUserName(String userName);
}
