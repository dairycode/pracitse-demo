package com.github.dairycode.io;

import java.io.*;

// 2 文件字符流
public class FileRW {
    public static void main(String[] args) {
        // 1.创建源
        File in = new File("words.txt");
        File out = new File("words-copy.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            // 2.选择流
            reader = new FileReader(in);
            writer = new FileWriter(out);
            // 3.操作
            char[] flush = new char[1024];
            int len = -1;
            while ((len=reader.read(flush))!=-1) {
                writer.write(flush, 0, len);
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
