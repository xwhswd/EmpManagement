package com.iweb.arui.dao;

import com.iweb.arui.pojo.User;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface UserDao {
    /**
     * 添加用户操作
     * @param user 不传入id,添加用户信息
     * @return 操作是否成功
     */
    boolean add(User user);

    /**
     * 删除用户操作
     * @param user 根据用户id删除用户
     * @return 操作是否成功
     */
    boolean delete(User user);

    /**
     * 更新用户操作
     * @param user 根据用户id更新用户信息
     * @return 返回操作是否成功
     */
    boolean update(User user);

    /**
     * 查询所有用户
     * @return 返回用户信息(不包括管理员)
     */
    List<User> selectAll();

    /**
     * 模糊查询用户信息
     * @param user 用户key
     * @return 返回用户数据集合
     */
    List<User> selectFuzzy(User user);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 返回对象
     */
    User selectByUsername(String username);

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 返回对象
     */
    User selectById(long id);
}
