package com.iweb.arui.view;

import com.iweb.arui.controller.AdminController;
import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.User;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class UserManageView {
    private static UserService userService;

    static {
        userService = new UserServiceImpl();
    }

    public static void userManageView(){
        Print.print("进入 用户管理 页面...");
        Print.print("请选择要进行的操作");
        Print.print("1.添加用户");
        Print.print("2.删除用户");
        Print.print("3.更新用户");
        Print.print("4.查询所有用户");
        Print.print("5.模糊筛选用户");
        Print.print("6.返回管理员界面");
        String choose = GetCommand.nextLine();
        AdminController.userManInfo(choose);
    }
    public static void addUser(){
        Print.print("请输入要添加的用户名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入要添加的密码:");
        String inputPassword = GetCommand.nextLine();
        Print.print("请输入要添加的角色:");
        String inputRole = GetCommand.nextLine();
        User user=new User(0,inputUserName,inputPassword,inputRole,"未登录");
        boolean f = userService.register(user);
        if (!f){
            Print.print("创建失败,请重新输入");
        }else {
            Print.print("创建成功");
            AdminView.adminView();
        }

    }

    public static void deleteUser(){
        String inputPassword = GetCommand.nextLine();
        Print.print("请输入要删除的用户id:");
        String inputId = GetCommand.nextLine();
        User user=new User(Long.parseLong(inputId),null,null,null,"未登录");
        boolean f = userService.unregister(user);
        if (!f){
            Print.print("删除失败,请重新输入");
        }else {
            Print.print("删除成功");
            AdminView.adminView();
        }
    }

    public static void updateUser(){
        Print.print("请输入要修改的用户id:");
        String inputId = GetCommand.nextLine();
        Print.print("请输入要修改的用户名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入要修改的密码:");
        String inputPassword = GetCommand.nextLine();
        Print.print("请输入要修改的角色:");
        String inputRole = GetCommand.nextLine();
        User user=new User(Long.parseLong(inputId),inputUserName,inputPassword,inputRole,"未登录");
        boolean f = userService.register(user);
        if (!f){
            Print.print("创建失败,请重新输入");
        }else {
            Print.print("创建成功");
            AdminView.adminView();
        }
    }

    public static void searchAllUser(){
        Print.print("以下是用户信息");
        List<User> allUsers = userService.getAllUsers();
        for (User u:allUsers) {
            Print.print(u.toString());
        }
        Print.print("显示结束,返回主页面");
        AdminView.adminView();
    }
    public static void searchUserByKey(){
        Print.print("请输入要查询的用户关键字:");
        String msg1 = GetCommand.nextLine();
        Print.print("请输入要查询的状态关键字:");
        String msg2 = GetCommand.nextLine();
        User user=new User(0,msg1,null,null,msg2);
        Print.print("以下是用户信息");
        List<User> allUsers = userService.searchUser(user);
        for (User u:allUsers) {
            Print.print(u.toString());
        }
        Print.print("显示结束,返回主页面");
        AdminView.adminView();
    }
}
