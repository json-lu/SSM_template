package com.ljx.exercise.test.socket;

import javax.net.SocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.SocketImpl;

/**
 * <p>
 *      socket客户端
 * </p>
 *
 * @Since: Created  in 14:25 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
public class client_socket {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try{
            Socket socket = new Socket("127.0.0.1",8081);
            is = socket.getInputStream();
            os = socket.getOutputStream();


            byte [] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b))!=-1){
                System.out.println(new String(b,"UTF-8"));
            }

            System.out.println("继续执行!");
            String msg = "服务器，我收到了你发送的文件!-----------来自客户端的新消息";
            os.write(msg.getBytes());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("client。。。。。。。。。");
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
