package com.iweb.arui;

import com.iweb.arui.pojo.Post;
import com.iweb.arui.service.PostService;
import com.iweb.arui.service.impl.PostServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class PostTest {
    PostService postService = new PostServiceImpl();

    @Test
    public void addPost(){
        System.out.println(postService.addPost(new Post(1, "开发总监", "abc")));
    }
    @Test
    public void deletePost(){
        System.out.println(postService.deletePost(new Post(2, null, null)));
    }
    @Test
    public void updatePost(){
        System.out.println(postService.updatePost(new Post(2, "会计", "这是会计")));
    }
    @Test
    public void selectAllPost(){
        System.out.println(postService.selectAllPost().toString());
    }
    @Test
    public void selectPostByKey(){
        System.out.println(postService.selectPostByKey(new Post(2,"会","")));
    }



}
