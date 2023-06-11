package com.iweb.arui.dao;

import com.iweb.arui.pojo.User;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface UserDao {
    boolean add(User user);
    boolean delete(User user);
    boolean update(User user);
    List<User> selectAll();
    List<User> selectFuzzy(User user);
    User selectByUsername(String username);
}
