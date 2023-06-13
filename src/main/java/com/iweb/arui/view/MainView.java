package com.iweb.arui.view;

import com.iweb.arui.Main;
import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.User;
import com.iweb.arui.service.ReportService;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.ReportServiceImpl;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;
import com.iweb.arui.util.StringUtil;


/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class MainView {
    private static UserService userService;
    private static ReportService reportService;

    static {
        userService = new UserServiceImpl();
        reportService = new ReportServiceImpl();
    }

    public static void mainView() {
        Print.print("欢迎来到员工管理系统");
        Print.print("请选择你想刚问的功能");
        Print.print("1.登录");
        Print.print("2.注册");
        Print.print("3.管理员登录");
        String choose = GetCommand.nextLine();
        UserController.mainController(choose);
    }

    public static void loginView() {
        Print.print("请输入您的用户名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = GetCommand.nextLine();
        String randomConfirmCode = StringUtil.getRandomStr(4);
        Print.print("验证码为:" + randomConfirmCode);
        Print.print("请输入您的验证码");
        String inputConfirmCode = GetCommand.nextLine();
        if (inputConfirmCode.equals(randomConfirmCode)) {
            User inputUser = new User(0, inputUserName, inputPassword, "普通用户", null);
            boolean flag = userService.login(inputUser);
            System.out.println(flag);
            if (flag) {
                MainView.userView();
            } else {
                Print.print("输入错误,请重新输入");
                MainView.mainView();
            }
        }
    }

    public static void userView() {
        Print.print("欢迎你,尊贵的用户,"+ Main.currentUser.get(Thread.currentThread()).getUsername()+"请选择你要访问的功能");
        Print.print("公告:+"+reportService.getNewestReport().getReportName());
        Print.print("  "+reportService.getNewestReport().getReportMsg());
        Print.print("1.员工管理");
        Print.print("2.部门管理");
        Print.print("3.职位管理");
        Print.print("4.退出登录,返回主界面");
        Print.print("5.显示所有公告信息");
        String choose = GetCommand.nextLine();
        UserController.userInfo(choose);
    }

    public static void registerView() {
        Print.print("请输入您的用户名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = GetCommand.nextLine();
        //数据封装在User对象中
        User registerUser = new User(0,inputUserName, inputPassword,"普通用户","未登录");
        //将数据交给业务类的注册方法进行逻辑判断
        userService.register(registerUser);
    }

    public static void updateUser() {
        Print.print("请输入要修改的用户名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入要修改的密码:");
        String inputPassword = GetCommand.nextLine();

        User update = new User(0,inputUserName, inputPassword,"普通用户","未登录");
        //将数据交给业务类的注册方法进行逻辑判断
        userService.updateUser(update);
    }

}
