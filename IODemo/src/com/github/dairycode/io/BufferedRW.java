package com.github.dairycode.io;

import java.io.*;

// 5 字符缓冲流
public class BufferedRW {
    public static void main(String[] args) {
        // 1.创建源
        File in = new File("words.txt");
        File out = new File("words-copy.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            // 2.选择流
            reader = new BufferedReader(new FileReader(in));
            writer = new BufferedWriter(new FileWriter(out));
            // 3.操作 (逐行读取)
            String line = null;
            while ((line=reader.readLine())!=null) {
                writer.write(line); // 逐行写出
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
