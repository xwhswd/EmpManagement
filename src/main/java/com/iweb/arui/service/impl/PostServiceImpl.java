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
        if (post==null){
            return false;
        }
        return postDao.add(post);
    }

    @Override
    public boolean deletePost(Post post) {
        if (post==null){
            return false;
        }
        return postDao.delete(post);
    }

    @Override
    public boolean updatePost(Post post) {
        if (post==null){
            return false;
        }
        return postDao.update(post);
    }

    @Override
    public List<Post> selectAllPost() {
        return postDao.selectAll();
    }

    @Override
    public List<Post> selectPostByKey(Post post) {
        if (post==null){
            return null;
        }
        return postDao.selectFuzzy(post);
    }
}
