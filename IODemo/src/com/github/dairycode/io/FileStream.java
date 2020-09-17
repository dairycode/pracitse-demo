package com.github.dairycode.io;

import java.io.*;

// 1 文件字节流
public class FileStream {
    public static void main(String[] args) {
        // 1.创建源
        File in = new File("words.txt");
        File out = new File("words-copy.txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            // 2.选择流
            is = new FileInputStream(in);
            os = new FileOutputStream(out);
            // 3.操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len=is.read(flush))!=-1) {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.释放资源
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
