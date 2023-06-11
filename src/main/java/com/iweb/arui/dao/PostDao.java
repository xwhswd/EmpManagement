package com.iweb.arui.dao;


import com.iweb.arui.pojo.Post;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface PostDao {
    boolean add(Post post);
    boolean delete(Post post);
    boolean update(Post post);
    List<Post> selectAll();
    List<Post> selectFuzzy(Post post);
}
