package com.iweb.arui.controller;

import com.iweb.arui.Main;
import com.iweb.arui.pojo.Report;
import com.iweb.arui.service.ReportService;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.ReportServiceImpl;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.Print;
import com.iweb.arui.view.*;

import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class UserController {
    static UserService userService=new UserServiceImpl();
    static ReportService reportService = new ReportServiceImpl();

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
                AdminController.adminController("1");
                break;
            default:
                //输入错误
                Print.print("输入错误信息,请重新输入");
                MainView.userView();
        }
    }

    public static void userInfo(String choose) {
        switch (choose) {
            case "1":
                Print.print("进入员工管理页面:");
                EmpManageView.empManageView();
                break;
            case "2":
                Print.print("进入部门管理页面:");
                DeptManageView.deptManageView();
                break;
            case "3":
                Print.print("进入职位管理页面:");
                PostManageView.postManageView();
                break;
            case "4":
                userService.unLogin(Main.currentUser.get(Thread.currentThread()));
                Main.currentUser.remove(Thread.currentThread());
                Print.print("注销成功,正在回到主页...");
                MainView.mainView();
                break;
            case "5":
                List<Report> list = reportService.selectAllReport();
                for (Report r:list) {
                    Print.print(r.toString());
                }
                MainView.userView();
            default:
        }
    }

    public static void empManInfo(String choose){
        switch (choose) {
            case "1":
                Print.print("进入添加员工界面:");
                EmpManageView.addEmp();
                break;
            case "2":
                Print.print("进入删除员工界面:");
                EmpManageView.deleteEmp();
                break;
            case "3":
                Print.print("进入更新员工界面:");
                EmpManageView.updateEmp();
                break;
            case "4":
                Print.print("进入查询员工界面:");
                EmpManageView.searchAllEmp();
                break;
            case "5":
                Print.print("进入模糊查询员工界面:");
                EmpManageView.searchEmpByKey();
            case "6":
                Print.print("正在返回用户页面页...");
                MainView.userView();
                break;
            default:
                Print.print("输入错误,请重新输入");
                EmpManageView.empManageView();
                break;
        }
    }
    public static void deptManInfo(String choose){
        switch (choose) {
            case "1":
                Print.print("进入添加部门界面:");
                DeptManageView.addDept();
                break;
            case "2":
                Print.print("进入删除部门界面:");
                DeptManageView.deleteDept();
                break;
            case "3":
                Print.print("进入更新部门界面:");
                DeptManageView.updateDept();
                break;
            case "4":
                Print.print("进入查询部门界面:");
                DeptManageView.searchAllDept();
                break;
            case "5":
                Print.print("进入模糊查询部门界面:");
                DeptManageView.searchDeptByKey();
            case "6":
                Print.print("正在返回用户页面页...");
                MainView.userView();
                break;
            default:
                Print.print("输入错误,请重新输入");
                DeptManageView.deptManageView();
                break;
        }
    }
    public static void postManInfo(String choose){
        switch (choose) {
            case "1":
                Print.print("进入添加职位界面:");
                PostManageView.addPost();
                break;
            case "2":
                Print.print("进入删除职位界面:");
                PostManageView.deletePost();
                break;
            case "3":
                Print.print("进入更新职位界面:");
                PostManageView.updatePost();
                break;
            case "4":
                Print.print("进入查询职位界面:");
                PostManageView.searchAllPost();
                break;
            case "5":
                Print.print("进入模糊查询职位界面:");
                PostManageView.searchPostByKey();
            case "6":
                Print.print("正在返回用户页面页...");
                MainView.userView();
                break;
            default:
                Print.print("输入错误,请重新输入");
                PostManageView.postManageView();
                break;
        }
    }


}
