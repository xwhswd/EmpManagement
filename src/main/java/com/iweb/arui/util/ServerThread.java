package com.iweb.arui.util;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;

/**
 * @author xwh
 * @version 1.0
 * 2023/6/11
 */
public class ServerThread extends Thread{
    Socket socket;
    List<Socket> list;
    InputStream is;
    DataInputStream dis;
    OutputStream os;
    DataOutputStream dos;

    public ServerThread(Socket s, List<Socket> list) {
        this.socket = s;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                is = socket.getInputStream();
                dis = new DataInputStream(is);
                String str = dis.readUTF();
                System.out.println(socket.getInetAddress() + ":" + str);

                if (socket.isConnected()) {
                    os = socket.getOutputStream();
                    dos = new DataOutputStream(os);
                    dos.writeUTF(socket.getInetAddress() + ":" + str);
                } else {
                    synchronized (list) {
                        list.remove(socket);
                        System.out.println(socket.getInetAddress() + "已经退出聊天室,当前在线人数为" + list.size());
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                if (!socket.isConnected()) {
                    socket.close();
                    list.remove(socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
