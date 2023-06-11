package com.iweb.arui.service;

import com.iweb.arui.pojo.Post;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface PostService {
    boolean addPost(Post post);
    boolean deletePost(Post post);
    boolean updatePost(Post post);
    List<Post> selectAllPost();
    List<Post> selectPostByKey(Post post);
}
