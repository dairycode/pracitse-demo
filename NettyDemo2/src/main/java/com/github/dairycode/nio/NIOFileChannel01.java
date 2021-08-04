package com.github.dairycode.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        String str = "hello,world";
        // 创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");

        // 通过fileOutputStream获取对应的FileChannel
        // 这个fileChannel真实类型是FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建一个缓冲区ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将str放入byteBuffer
        byteBuffer.put(str.getBytes());

        // 对byteBuffer进行flip
        byteBuffer.flip();

        // 将byteBuffer数据写入到fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
