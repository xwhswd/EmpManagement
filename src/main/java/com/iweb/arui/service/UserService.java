package com.iweb.arui.service;

import com.iweb.arui.pojo.User;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface UserService {
    /**
     * 用户登录接口
     * @param user 用户信息
     * @return 校验结果
     */
    boolean login(User user);

    /**
     * 离线操作接口
     * @param user 用户id传入
     * @return 校验结果
     */
    boolean unLogin(User user);

    /**
     * 注册接口
     * @param user 用户信息
     * @return 校验结果
     */
    boolean register(User user);

    /**
     * 注销接口
     * @param user 根据用户id
     * @return 校验结果
     */
    boolean unregister(User user);

    /**
     * 用户更新接口
     * @param user 根据id更新
     * @return 校验结果
     */
    boolean updateUser(User user);

    /**
     * 查询公司所有用户接口
     * @return 员工集合
     */
    List<User> getAllUsers();

    /**
     * 模糊查询用户
     * @param user 查询的key
     * @return 员工集合
     */
    List<User> searchUser(User user);
}
