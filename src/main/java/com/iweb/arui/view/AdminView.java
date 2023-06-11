package com.iweb.arui.view;

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
        //调用业务类 进行登录的逻辑判断 根据业务类返回的boolean值结果决定
        //下一步如何实现
        //封装数据
//        User inputUser = new User(inputUserName, inputPassword, null);
//        userService.login(inputUser, randomConfirmCode, inputConfirmCode);

    }
}
