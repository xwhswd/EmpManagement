package com.iweb.arui.controller;

import com.iweb.arui.Main;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.Print;
import com.iweb.arui.view.AdminView;
import com.iweb.arui.view.MainView;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class UserController {

    public static void mainController(String choose) {
        switch (choose) {
            case "1":
                //跳转到登录视图
                MainView.loginView();
                break;
            case "2":
                //跳转到注册视图
                MainView.registerView();
                break;
            case "3":
                //跳转到管理员登录界面
                AdminView.loginView();
            default:
                //输入错误
                MainView.mainView();
        }
    }

    public static void userInfo(String choose) {
        switch (choose) {
            case "1":
                Print.print("用户信息如下:");
                Print.print(Main.currentUser.toString());
                MainView.userView();
                break;
            case "2":
                Print.print("即将跳转修改用户信息界面...");
//                MainView.updateUser();
                break;
            case "3":
                //清空currentUser 返回主页面
                Main.currentUser = null;
                MainView.mainView();
                break;
            case "4":
//                Data.getUserList().remove(Main.currentUser);
                int[] ints = new int[3];
                Main.currentUser = null;
                MainView.mainView();
                break;
            case "5":
                Print.print("正在返回主页面...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MainView.mainView();
                break;
            default:
        }
    }
}
