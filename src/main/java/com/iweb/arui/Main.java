package com.iweb.arui;

import com.iweb.arui.pojo.User;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.util.PrintThread;
import com.iweb.arui.view.MainView;
import com.iweb.arui.view.UserManageView;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 員工管理系統
 *
 */
public class Main {
    public volatile static HashMap<Thread,Socket> map = new HashMap<>();
    public volatile static HashMap<Thread,User> currentUser = new HashMap<>();
    private  static ThreadPoolExecutor executor= new ThreadPoolExecutor(10,
                                          100,
                                          60,
                                          TimeUnit.SECONDS,
                                          new LinkedBlockingDeque<Runnable>());

    public static void main( String[] args ) throws IOException {
        List<Socket> list=new ArrayList<>();
        ServerSocket ss = new ServerSocket(8888);
        try {
            while (true){
                Socket socket = ss.accept();
                PrintThread printThread = new PrintThread(socket, list);
                executor.execute(printThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
