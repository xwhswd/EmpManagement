package com.iweb.arui.service;

import com.iweb.arui.pojo.Post;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface PostService {
    /**
     * 添加职位信息接口
     * @param post 职位信息
     * @return 校验结果
     */
    boolean addPost(Post post);

    /**
     * 删除职位接口
     * @param post 根据id
     * @return 校验结果
     */
    boolean deletePost(Post post);

    /**
     * 更新职位接口
     * @param post 根据id
     * @return 校验结果
     */
    boolean updatePost(Post post);

    /**
     * 查询公司所有职位接口
     * @return 所有职位的集合
     */
    List<Post> selectAllPost();

    /**
     * 模糊查询公司所有职位接口
     * @return 查询到的所有职位的集合
     */
    List<Post> selectPostByKey(Post post);
}
