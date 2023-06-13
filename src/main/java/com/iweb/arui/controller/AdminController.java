package com.iweb.arui.controller;

import com.iweb.arui.Main;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.Print;
import com.iweb.arui.view.*;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class AdminController {
    static UserService userService=new UserServiceImpl();
    public static void adminController(String choose) {
        switch (choose) {
            case "1":
                Print.print("正在进入登录界面");
                AdminView.loginView();
                break;
            default:
                //输入错误
                MainView.mainView();
        }
    }

    public static void adminInfo(String choose) {
        switch (choose) {
            case "1":
                Print.print("进入用户管理页面:");
                UserManageView.userManageView();
                break;
            case "2":
                Print.print("进入公告管理页面:");
                ReportManageView.reportManageView();
                break;
            case "3":
                userService.unLogin(Main.currentUser.get(Thread.currentThread()));
                Main.currentUser.remove(Thread.currentThread());
                Print.print("注销成功,正在回到主页...");
                MainView.mainView();
                break;
            default:
        }
    }

    public static void userManInfo(String choose){
        switch (choose) {
            case "1":
                Print.print("进入添加用户界面:");
                UserManageView.addUser();
                break;
            case "2":
                Print.print("进入删除用户界面:");
                UserManageView.deleteUser();
                break;
            case "3":
                Print.print("进入更新用户界面:");
                UserManageView.updateUser();
                break;
            case "4":
                Print.print("进入查询用户界面:");
                UserManageView.searchAllUser();
                break;
            case "5":
                Print.print("进入模糊查询用户界面:");
                UserManageView.searchUserByKey();
            case "6":
                Print.print("正在返回管理员页面页...");
                AdminView.adminView();
                break;
            default:
                Print.print("输入错误,请重新输入");
                UserManageView.userManageView();
                break;
        }
    }
    public static void reportManInfo(String choose){
        switch (choose) {
            case "1":
                Print.print("进入添加公告界面:");
                ReportManageView.addReport();
                break;
            case "2":
                Print.print("进入删除公告界面:");
                ReportManageView.deleteReport();
                break;
            case "3":
                Print.print("进入更新公告界面:");
                ReportManageView.updateReport();
                break;
            case "4":
                Print.print("进入查询公告界面:");
                ReportManageView.searchAllReport();
                break;
            case "5":
                Print.print("进入模糊查询公告界面:");
                ReportManageView.searchReportByKey();
            case "6":
                Print.print("正在返回管理员页面页...");
                AdminView.adminView();
                break;
            default:
                Print.print("输入错误,请重新输入");
                ReportManageView.reportManageView();
                break;
        }
    }
}
