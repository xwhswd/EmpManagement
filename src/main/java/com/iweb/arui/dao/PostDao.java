package com.iweb.arui.dao;


import com.iweb.arui.pojo.Post;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public interface PostDao {
    void add(Post post);
    void delete(Post post);
    void update(Post post);
    List<Post> selectAll();
    List<Post> selectFuzzy(Post post);
}
