package com.github.dairycode.io;

import java.io.*;

// 3 字节数组流
public class ByteArrayStream {
    public static void main(String[] args) {
        // 1.创建源
        String words = "你好呀!我是一段文字!";
        byte[] wordsByte = words.getBytes();
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;
        try {
            // 2.选择流
            bais = new ByteArrayInputStream(wordsByte);
            baos = new ByteArrayOutputStream();
            // 4.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=bais.read(flush))!=-1) {
                baos.write(flush, 0, len);
            }
            baos.flush();
            byte[] wordsByteCopy = baos.toByteArray();
            String wordsCopy = new String(wordsByteCopy);
            System.out.println(wordsCopy);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4.字节数组流与内存打交道,不用手动关闭资源
    }
}
