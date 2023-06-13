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
    static List<Connection> cs = new ArrayList<>();
    //定义变量指定连接池大小
    static int size;
    static {
        size = 10;
        init();
    }

    //定义初始化方法,用来创建连接对象
    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/emp_management?characterEncoding=utf8","root","123456");
                cs.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnection(){
        while (cs.isEmpty()){
            try {
                DB_Pool.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }

    public synchronized static void returnConnection(Connection c) {
        cs.add(c);
        DB_Pool.class.notifyAll();
    }
}
