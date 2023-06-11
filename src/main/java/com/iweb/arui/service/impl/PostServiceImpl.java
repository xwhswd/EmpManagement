package com.iweb.arui.service.impl;

import com.iweb.arui.dao.PostDao;
import com.iweb.arui.dao.impl.PostDaoImpl;
import com.iweb.arui.pojo.Post;
import com.iweb.arui.service.PostService;
import sun.dc.pr.PRError;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/11
 */
public class PostServiceImpl implements PostService {
    private static PostDao postDao;
    static {
        postDao=new PostDaoImpl();
    }
    @Override
    public boolean addPost(Post post) {
        return false;
    }

    @Override
    public boolean deletePost(Post post) {
        return false;
    }

    @Override
    public boolean updatePost(Post post) {
        return false;
    }

    @Override
    public List<Post> selectAllPost() {
        return null;
    }

    @Override
    public List<Post> selectPostByKey(Post post) {
        return null;
    }
}
