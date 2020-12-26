package com.ljx.exercise.test.socket;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 * <p>
 * socket服务端
 * </p>
 *
 * @Since: Created  in 14:25 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
public class server_socket {

    public static void main(String[] args) {
        OutputStream os = null;
        InputStream is = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            System.out.println("等待客户端连接!!!!");
            long start = System.currentTimeMillis();
            Socket socket = serverSocket.accept();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            os = socket.getOutputStream();
            is = socket.getInputStream();

            String response = "连接成功,这是我发送给你的消息!-----来自服务器的回应";
            //is = server_socket.class.getClassLoader().getResourceAsStream("db.properties");
            os.write(response.getBytes());
            System.out.println("继续执行!");
            System.out.println(2<<8);

            byte[] b = new byte[1024];
            int len = 0;
            System.out.println("开始读取客户端传递的信息!");
            while ((len = is.read(b)) != -1) {
                System.out.println(new String(b, "UTF-8"));
            }
            System.out.println("!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("server............");
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
