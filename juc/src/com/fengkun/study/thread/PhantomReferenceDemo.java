package com.fengkun.study.thread;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 虚引用
 */
public class PhantomReferenceDemo {

  public static void main(String[] args) {

    Object o1 = new Object();

    // 创建引用队列
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

    // 创建一个弱引用
//    WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

    // 创建一个弱引用
    PhantomReference<Object> weakReference = new PhantomReference<>(o1, referenceQueue);

    System.out.println(o1);
    System.out.println(weakReference.get());
    // 取队列中的内容
    System.out.println(referenceQueue.poll());

    o1 = null;
    System.gc();
    System.out.println("执行GC操作");

    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(o1);
    System.out.println(weakReference.get());
    // 取队列中的内容
    System.out.println(referenceQueue.poll());

  }
}
