package com.iweb.arui;

import com.iweb.arui.pojo.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Main {
    public static User currentUser=null;
    public static void main( String[] args ) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true){
                Socket accept = ss.accept();

            }
        } catch (IOException e) {

        }finally {

        }
    }
}
