package com.iweb.arui.util;

import com.iweb.arui.Main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/10
 */
public class Print {

    public static void print(String str){
        Socket socket= Main.map.get(Thread.currentThread());
        try {
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(str);
            dos.flush();
        } catch (IOException e) {
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
