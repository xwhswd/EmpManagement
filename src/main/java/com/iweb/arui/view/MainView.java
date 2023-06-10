package com.iweb.arui.view;

import com.iweb.arui.Main;
import com.iweb.arui.controller.UserController;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.Print;
import com.iweb.arui.util.StringUtil;

import java.util.Scanner;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class MainView {
    private static Scanner sc = new Scanner(System.in);
    private static UserService userService = new UserServiceImpl();

    public static void mainView() {
        Print.print("欢迎来到员工管理系统");
        Print.print("请选择你想刚问的功能");
        Print.print("1.登录");
        Print.print("2.注册");
        Print.print("3.管理员登录");
        String choose = sc.nextLine();
        //应该根据用户的输入的选择 跳转不到的页面
        //注意 需要控制异常输入的情况
        UserController.mainController(choose);
    }

    public static void loginView() {
        Print.print("请输入您的用户名:");
        String inputUserName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = sc.nextLine();
        String randomConfirmCode = StringUtil.getRandomStr(4);
        Print.print("验证码为:" + randomConfirmCode);
        Print.print("请输入您的验证码");
        String inputConfirmCode = sc.nextLine();
        //调用业务类 进行登录的逻辑判断 根据业务类返回的boolean值结果决定
        //下一步如何实现
        //封装数据
//        User inputUser = new User(inputUserName, inputPassword, null);
//        userService.login(inputUser, randomConfirmCode, inputConfirmCode);

    }

    public static void userView() {
        Print.print("欢迎你,尊贵的用户,"+ Main.currentUser+"请选择你要访问的功能");
        Print.print("1.查看用户信息");
        Print.print("2.修改用户信息");
        Print.print("3.退出登录");
        Print.print("4.注销用户");
        Print.print("5.返回主页面");
        String choose = sc.nextLine();
//        UserController.userInfo(choose);
    }

    public static void registerView() {
        Print.print("请输入您的用户名:");
        String inputUserName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = sc.nextLine();
        Print.print("请输入您的邮箱:");
        String inputEmail = sc.nextLine();
        //数据封装在User对象中
//        User registerUser = new User(inputUserName, inputPassword, inputEmail);
        //将数据交给业务类的注册方法进行逻辑判断
//        userService.register(registerUser);
    }

}
