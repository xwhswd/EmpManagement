package com.iweb.arui.controller;

import com.iweb.arui.util.Print;

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
//                MainView.loginView();
                break;
            case "2":
                //跳转到注册视图
//                MainView.registerView();
                break;
            case "3":
                Print.print("输入异常,请重新输入");
//                MainView.mainView();
        }
    }


}
