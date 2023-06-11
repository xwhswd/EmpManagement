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
                //遍历所有socket,向用户广播消息
                Iterator<Socket> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Socket st = iterator.next();
                    if (st.isConnected()) {
                        os = st.getOutputStream();
                        dos = new DataOutputStream(os);
                        dos.writeUTF(socket.getInetAddress() + ":" + str);
                    } else {
                        synchronized (list) {
                            iterator.remove();
                            System.out.println(st.getInetAddress() + "已经关闭连接" + list.size());
                        }
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
