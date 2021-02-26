package com.jackding.nio.demo.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO的通道类似流，但又有些不同：
 * 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
 * 通道可以异步地读写。
 * 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。
 * @author dh
 * @version 1.0
 * @date created by 2021/2/26 16:41
 * @description
 **/
public class ChannelDemo {
    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("F:\\11.dat", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(byteBuffer);
        while (bytesRead != -1){
            System.out.println("Read "+bytesRead);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                System.out.println((char)byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = channel.read(byteBuffer);
        }
        aFile.close();
    }
}
