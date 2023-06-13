package com.iweb.arui.view;

import com.iweb.arui.Main;
import com.iweb.arui.controller.AdminController;
import com.iweb.arui.controller.UserController;
import com.iweb.arui.pojo.User;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.GetCommand;
import com.iweb.arui.util.Print;
import com.iweb.arui.util.StringUtil;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class AdminView {
    private static UserService userService;

    static {
        userService = new UserServiceImpl();
    }

    public static void adminView() {
        Print.print("欢迎你,尊贵的管理员,"+ Main.currentUser.get(Thread.currentThread()).getUsername()+"请选择你要访问的功能");
        Print.print("1.用户管理");
        Print.print("2.公告管理");
        Print.print("3.退出登录,返回主界面");
        String choose = GetCommand.nextLine();
        AdminController.adminInfo(choose);
    }

    public static void loginView() {
        Print.print("请输入管理员用户名:");
        String inputUserName = GetCommand.nextLine();
        Print.print("请输入管理员密码:");
        String inputPassword = GetCommand.nextLine();
        String randomConfirmCode = StringUtil.getRandomStr(4);
        Print.print("验证码为:" + randomConfirmCode);
        Print.print("请输入您的验证码");
        String inputConfirmCode = GetCommand.nextLine();
        if (inputConfirmCode.equals(randomConfirmCode)) {
            User inputUser = new User(0, inputUserName, inputPassword, "管理员", "未登录");
            boolean flag = userService.login(inputUser);
            if (flag) {
                AdminView.adminView();
            } else {
                Print.print("输入错误,请重新输入");
                AdminView.loginView();
            }
        }
    }

}
