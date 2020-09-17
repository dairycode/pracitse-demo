package com.github.dairycode.io;

import java.io.*;

// 6 转换流
public class StreamRW {
    public static void main(String[] args) {
        // 操作System.in和System.out
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));) {
            // 循环获取键盘的输入(exit退出),输出此内容
            String msg = "";
            while (!"exit".equals(msg)) {
                msg = reader.readLine();    // 循环读取
                writer.write(msg);          // 循环写出
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
