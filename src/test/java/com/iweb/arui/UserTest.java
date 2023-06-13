package com.iweb.arui;

import com.iweb.arui.pojo.User;
import com.iweb.arui.service.UserService;
import com.iweb.arui.service.impl.UserServiceImpl;
import org.junit.Test;


/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class UserTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void testLogin(){
        System.out.println(userService.login(new User(1, "user1", "123456", "普通用户", null)));
    }

    @Test
    public void testUnLogin(){
        System.out.println(userService.unLogin(new User(1, "user1", "123456", null, null)));
    }

    @Test
    public void testRegister(){
        System.out.println(userService.register(new User(1, "user2", "123456", "", "")));
    }

    @Test
    public void testUnregister(){
        System.out.println(userService.unregister(new User(2, "", "", "", "")));
    }

    @Test
    public void updateUser(){
        System.out.println(userService.updateUser(new User(2, "user3", "121212", "管理员", "")));
    }

    @Test
    public void getAllUsers(){
        System.out.println(userService.getAllUsers().toString());
    }

    @Test
    public void searchUser(){
        System.out.println(userService.searchUser(new User(1,"user","","","")));
    }
}
