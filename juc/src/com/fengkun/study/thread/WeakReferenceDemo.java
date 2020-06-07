package com.fengkun.study.thread;

import java.lang.ref.WeakReference;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 弱引用
 * 不管内存是否够，只要有GC操作就会进行回收
 * <p>
 * 弱引用需要用 java.lang.ref.WeakReference 类来实现，它比软引用生存期更短
 * <p>
 * 对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，都会回收该对象占用的空间。
 */
public class WeakReferenceDemo {

  public static void main(String[] args) {
    Object o1 = new Object();
    WeakReference<Object> weakReference = new WeakReference<>(o1);
    System.out.println(o1);
    System.out.println(weakReference.get());
    o1 = null;
    System.gc();
    System.out.println(o1);
    System.out.println(weakReference.get());

  }
}
