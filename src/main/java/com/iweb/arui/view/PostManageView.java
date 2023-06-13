package com.iweb.arui.view;

import com.iweb.arui.Main;
import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.Post;
import com.iweb.arui.pojo.Report;
import com.iweb.arui.service.PostService;
import com.iweb.arui.service.impl.PostServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class PostManageView {
    static PostService postService;
    static {
        postService=new PostServiceImpl();
    }
    public static void postManageView(){
        Print.print("进入 职位管理 页面...");
        Print.print("请选择要进行的操作");
        Print.print("1.添加职位");
        Print.print("2.删除职位");
        Print.print("3.删除职位");
        Print.print("4.查询所有职位");
        Print.print("5.模糊筛选职位");
        Print.print("6.返回用户界面");
        String choose = GetCommand.nextLine();
        UserController.postManInfo(choose);
    }
    public static void addPost(){
        Print.print("请输入要添加的职位名:");
        String inputPostName = GetCommand.nextLine();
        Print.print("请输入要添加的职位信息:");
        String inputPostMsg = GetCommand.nextLine();
        Post post = new Post(0, inputPostName, inputPostMsg);
        boolean b = postService.addPost(post);
        if (b){
            Print.print("添加成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            PostManageView.addPost();
        }
    }
    public static void deletePost(){
        Print.print("请输入要删除的职位id:");
        String inputId = GetCommand.nextLine();
        Post post = new Post(Long.parseLong(inputId), null, null);
        boolean b = postService.deletePost(post);
        if (b){
            Print.print("删除成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            PostManageView.addPost();
        }
    }
    public static void updatePost(){
        Print.print("请输入要更新的职位id:");
        String inputId = GetCommand.nextLine();
        Print.print("请输入要更新的职位名:");
        String inputPostName = GetCommand.nextLine();
        Print.print("请输入要更新的职位信息:");
        String inputPostMsg = GetCommand.nextLine();
        Post post = new Post(Long.parseLong(inputId), inputPostName, inputPostMsg);
        boolean b = postService.updatePost(post);
        if (b){
            Print.print("添加成功");
            AdminView.adminView();
        }else {
            Print.print("输入错误,请重新输入");
            PostManageView.addPost();
        }
    }
    public static void searchAllPost(){
        Print.print("以下是职位信息:");
        List<Post> list = postService.selectAllPost();
        for (Post r:list) {
            Print.print(r.toString());
        }
        Print.print("显示结束,返回主页面");
        MainView.userView();
    }
    public static void searchPostByKey(){
        Print.print("请输入要查询的职位名key:");
        String inputName = GetCommand.nextLine();
        Print.print("请输入要查询的职位信息key:");
        String inputMsg = GetCommand.nextLine();
        Print.print("以下是职位信息:");
        List<Post> list = postService.selectPostByKey(new Post(0,inputName,inputMsg));
        for (Post r:list) {
            Print.print(r.toString());
        }
        Print.print("显示结束,返回主页面");
        MainView.userView();
    }
}
