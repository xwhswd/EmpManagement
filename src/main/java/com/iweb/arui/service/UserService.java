package com.iweb.arui.service;

import com.iweb.arui.pojo.User;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface UserService {
    boolean login(User user);
    boolean register(User user);
    boolean unregister(User user);
    boolean updateUser(User user);
    List<User> getAllUsers();
    List<User> searchUser(User user);
}
