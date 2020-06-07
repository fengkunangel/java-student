package com.fengkun.study.thread;

import java.nio.ByteBuffer;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 写NIO程序的时候经常会使用ByteBuffer来读取或写入数据，这是一种基于通道(Channel) 与 缓冲区(Buffer)的I/O方式，它可以使用Native 函数库直接分配堆外内存，然后通过一个存储在Java堆里面的DirectByteBuffer对象作为这块内存的引用进行操作。这样能在一些场景中显著提高性能，因为避免了在Java堆和Native堆中来回复制数据。
 */
public class DirectBufferMemoryDemo {

  public static void main(String[] args) {

    System.out.println("配置的MaxDirectMemorySize" + (sun.misc.VM.maxDirectMemory()) / (double) 1024 / 1024 + "MB");

    // 只设置了5M的物理内存使用，但是却分配 6M的空间
    ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
  }
}
