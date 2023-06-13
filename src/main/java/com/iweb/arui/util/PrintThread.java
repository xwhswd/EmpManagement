package com.iweb.arui.util;

import com.iweb.arui.Main;
import com.iweb.arui.pojo.User;
import com.iweb.arui.service.impl.UserServiceImpl;
import com.iweb.arui.view.MainView;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class PrintThread extends Thread{
    Socket socket;
    List<Socket> list;

    public PrintThread(Socket s, List<Socket> list) {
        this.socket = s;
        this.list = list;
    }
    @Override
    public void run() {
        try {
            Main.map.put(Thread.currentThread(),socket);
            Main.currentUser.put(Thread.currentThread(),null);
            System.out.println("启动线程"+Thread.currentThread());
            while (true){
                if (socket.isConnected()) {
                    MainView.mainView();
                } else {
                    synchronized (list) {
                        list.remove(socket);
                        Thread key=null;
                        for (Map.Entry<Thread,Socket> entry:Main.map.entrySet()) {
                            if (entry.getValue().equals(socket)){
                                key=entry.getKey();
                            }
                        }
                        Main.map.remove(key);
                        System.out.println(socket.getInetAddress() + "已经断开连接,当前连接数为:" + list.size());
                    }
                }
            }
        } catch (Exception e) {

        }finally {
            if (!Main.map.get(Thread.currentThread()).isConnected()){
                synchronized (list) {
                    synchronized (Main.map){
                        synchronized (Main.currentUser){
                            list.remove(socket);
                            Thread key=Thread.currentThread();
                            Main.map.remove(key);
                            new UserServiceImpl().unLogin(Main.currentUser.get(key));
                            Main.currentUser.remove(key);
                            System.out.println(socket.getInetAddress() + "已经断开连接,当前连接数为:" + list.size());
                        }
                    }
                }
            }
        }
    }
}
