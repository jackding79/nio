package com.jackding.nio.demo.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * Java NIO中的Buffer用于和NIO通道进行通信 。如你所知，数据是从通道读入缓冲区，从缓冲区写入通道
 *
 * 缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO buffer对象，并提供了
 * 一组方法，用来方便的访问改块内存
 *
 *
 * @author dh
 * @version 1.0
 * @date created by 2021/2/26 16:57
 * @description
 **/
public class BufferDemo {
    /**
     *   使用Buffer读写数据一般遵循以下四个步骤：
     *   1.写入数据到buffer
     *   2.调用flip方法
     *   3.从buffer读取数据
     *   4.调用clear或者compact方法
     *
     *   当向buffer写入数据时，buffer会记录写入了多少数据。一旦要读取数据，需要通过flip()方法
     *   将buffer从写模式切换到读模式。在读模式下可以读取之前写入到Buffer的所有数据。
     *   一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式可以清空缓冲区：
     *   调用#clear()或者compact()方法。clear会清空整个缓冲区。compact只会清除已读过的数据。
     *   任何未读过的数据都会被移到缓冲区的起始处，新写入的数据将放在缓冲区未读数据的后面。
     */
    public static void demo1() throws Exception{
        RandomAccessFile file = new RandomAccessFile("F:\\11.dat","rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = fileChannel.read(buf);
        while (bytesRead != -1){
            buf.flip();

        }
    }


    public static void main(String[] args) throws Exception{

    }
}
