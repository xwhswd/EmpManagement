package com.iweb.arui.dao;


import com.iweb.arui.pojo.Post;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface PostDao {
    /**
     * 添加职位信息
     * @param post 不传入id,添加职务
     * @return 返回操作是否成功
     */
    boolean add(Post post);

    /**
     * 根据id删除职位
     * @param post 只用id 信息
     * @return 操作是否成功
     */
    boolean delete(Post post);

    /**
     * 更新职位信息
     * @param post  根据id更新职位
     * @return 操作是否成功
     */
    boolean update(Post post);

    /**
     * 查询所有的职位
     * @return 所有职位的集合
     */
    List<Post> selectAll();

    /**
     * 模糊查询所有职位
     * @param post 传入模糊查询的key
     * @return 返回查询到的集合
     */
    List<Post> selectFuzzy(Post post);

    /**
     * 根据id查询职位
     * @param id 职位id
     * @return 返回查询到的职位
     */
    Post selectById(long id);
}
