package com.iweb.arui.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class DB_Pool {
    List<Connection> cs = new ArrayList<>();
    //定义变量指定连接池大小
    int size;


    //定义初始化方法,用来创建连接对象
    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=utf-8", "root", "123456");
                cs.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义构造方法,用于初始化size以及调用init方法创建链接
    public DB_Pool(int size) {
        this.size = size;
        init();
    }

    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return cs.remove(0);
    }

    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }
}
