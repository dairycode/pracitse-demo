package com.github.dairycode.tcp2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        // 1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);
        // 2.创建一个输出流
        OutputStream os = socket.getOutputStream();
        // 3.读取文件
        FileInputStream fis = new FileInputStream(new File("tcp_client.jpg"));
        // 4.写出文件
        byte[] buffer1 = new byte[1024];
        int len1;
        while ((len1=fis.read(buffer1)) != -1) {
            os.write(buffer1, 0, len1);
        }

        // 通知服务器,我已经结束了
        socket.shutdownOutput();    // 我已经传输完了

        // 确定服务器接收完毕,才能断开连接
        InputStream inputStream = socket.getInputStream();
        // String byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }

        System.out.println(baos.toString());

        // 5.关闭资源
        fis.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }
}
