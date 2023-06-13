package com.iweb.arui.util;

import com.iweb.arui.Main;

import java.io.*;
import java.net.Socket;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/12
 */
public class GetCommand {
    static Socket socket;

    public static  String nextLine(){
        String msg = null;
        try {
            socket= Main.map.get(Thread.currentThread());
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            msg=dis.readUTF();
        } catch (IOException e) {

        }
        return msg;
    }
}
