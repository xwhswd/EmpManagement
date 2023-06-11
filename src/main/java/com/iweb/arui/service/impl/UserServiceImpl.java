package com.iweb.arui.service.impl;

import com.iweb.arui.dao.UserDao;
import com.iweb.arui.dao.impl.UserDaoImpl;
import com.iweb.arui.pojo.User;
import com.iweb.arui.service.UserService;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class UserServiceImpl implements UserService {
    private static UserDao userDao;
    static {
        userDao=new UserDaoImpl();
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean unregister(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> searchUser(User user) {
        return null;
    }
}
