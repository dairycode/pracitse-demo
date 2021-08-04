package com.github.dairycode.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("tests.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {  // 循环读取
            // ps:这里有一个重要的操作，一定不要忘了
            byteBuffer.clear(); // 清空buffer

            int read = fileChannel01.read(byteBuffer);
            if (read == -1) {   // 表示读完
                break;
            }
            // 将buffer中的数据写入到fileChannel02
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }
        // 关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
