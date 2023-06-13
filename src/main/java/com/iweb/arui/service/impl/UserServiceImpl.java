package com.iweb.arui.service.impl;

import com.iweb.arui.Main;
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
        if (user==null){
            return false;
        }
        User u = userDao.selectByUsername(user.getUsername());
        if (u==null){
            return false;
        }else {
            Main.currentUser.put(Thread.currentThread(),u);
        }
        if (u.getPassword().equals(user.getPassword())&&u.getRole().equals(user.getRole())&&(u.getStatus().equals("未登录"))){
            u.setStatus("已登录");
            userDao.update(u);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean unLogin(User user) {
        user=userDao.selectById(user.getId());
        user.setStatus("未登录");
        boolean update = userDao.update(user);
        return update;
    }

    @Override
    public boolean register(User user) {
       if (user==null){
           return false;
       }
       return userDao.add(user);
    }

    @Override
    public boolean unregister(User user) {
        if (user==null){
            return false;
        }
        User u = userDao.selectById(user.getId());
        if (u.getRole().equals("管理员")||u.getStatus()=="已登录"){
            return false;
        }
        return userDao.delete(user);
    }

    @Override
    public boolean updateUser(User user) {
        if (user==null){
            return false;
        }
        return userDao.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.selectAll();
    }

    @Override
    public List<User> searchUser(User user) {
        if (user==null){
            return null;
        }
        return userDao.selectFuzzy(user);
    }
}
