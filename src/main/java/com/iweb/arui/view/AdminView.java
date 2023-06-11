package com.iweb.arui.view;

import com.iweb.arui.Main;
import com.iweb.arui.util.Print;
import com.iweb.arui.util.StringUtil;

import java.util.Scanner;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class AdminView {
    private static Scanner sc = new Scanner(System.in);


    public static void loginView() {
        Print.print("请输入您的用户名:");
        String inputUserName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassword = sc.nextLine();
        String randomConfirmCode = StringUtil.getRandomStr(4);
        Print.print("验证码为:" + randomConfirmCode);
        Print.print("请输入您的验证码");
        String inputConfirmCode = sc.nextLine();

    }


    public static void adminView() {
        Print.print("欢迎你,尊贵的用户,"+ Main.currentUser+"请选择你要访问的功能");
        Print.print("1.查看用户信息");
        Print.print("2.修改用户信息");
        Print.print("3.退出登录");
        Print.print("4.注销用户");
        Print.print("5.返回主页面");
        String choose = sc.nextLine();
//        UserController.userInfo(choose);
    }

}
