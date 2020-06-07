package com.fengkun.study.thread;

import java.lang.ref.SoftReference;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 软引用
 * 软引用是一种相对弱化了一些的引用，需要用Java.lang.ref.SoftReference类来实现，可以让对象豁免一些垃圾收集，对于只有软引用的对象来讲：
 * 当系统内存充足时，它不会被回收
 * 当系统内存不足时，它会被回收
 */
public class SoftReferenceDemo {

  /**
   * 内存够用的时候
   */
  public static void softRefMemoryEnough() {
    // 创建一个强应用
    Object o1 = new Object();
    // 创建一个软引用
    SoftReference<Object> softReference = new SoftReference<>(o1);
    System.out.println(o1);
    System.out.println(softReference.get());

    o1 = null;
    // 手动GC
    System.gc();

    System.out.println(o1);
    System.out.println(softReference.get());
  }

  /**
   * JVM配置，故意产生大对象并配置小的内存，让它的内存不够用了导致OOM，看软引用的回收情况
   * -Xms5m -Xmx5m -XX:+PrintGCDetails
   */
  public static void softRefMemoryNoEnough() {

    System.out.println("========================");
    // 创建一个强应用
    Object o1 = new Object();
    // 创建一个软引用
    SoftReference<Object> softReference = new SoftReference<>(o1);
    System.out.println(o1);
    System.out.println(softReference.get());

    o1 = null;

    // 模拟OOM自动GC
    try {
      // 创建30M的大对象
      byte[] bytes = new byte[30 * 1024 * 1024];
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println(o1);
      System.out.println(softReference.get());
    }
  }

  public static void main(String[] args) {

//    softRefMemoryEnough();

    softRefMemoryNoEnough();
  }
}
