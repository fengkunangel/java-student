package com.fengkun.study.thread;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 强引用
 */
public class StrongReferenceDemo {

  public static void main(String[] args) {
    // 这样定义的默认就是强应用
    Object obj1 = new Object();

    // 使用第二个引用，指向刚刚创建的Object对象
    Object obj2 = obj1;

    // 置空
    obj1 = null;

    // 垃圾回收
    System.gc();

    System.out.println(obj1);

    System.out.println(obj2);
  }
}
