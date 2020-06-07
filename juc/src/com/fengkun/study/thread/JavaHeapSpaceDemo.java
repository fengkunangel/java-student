package com.fengkun.study.thread;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： Java堆内存不足
 */
public class JavaHeapSpaceDemo {

  public static void main(String[] args) {

    // 堆空间的大小 -Xms10m -Xmx10m
    // 创建一个 80M的字节数组
    byte [] bytes = new byte[80 * 1024 * 1024];
  }
}
