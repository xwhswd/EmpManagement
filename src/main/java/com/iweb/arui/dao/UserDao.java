package com.iweb.arui.dao;

import com.iweb.arui.pojo.User;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface UserDao {
    void add(User user);
    void delete(User user);
    void update(User user);
    List<User> selectAll();
    List<User> selectFuzzy(User user);
}
