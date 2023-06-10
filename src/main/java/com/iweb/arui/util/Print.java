package com.iweb.arui.util;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class Print {
    public static void print(String str){
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
