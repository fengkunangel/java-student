package com.fengkun.study.thread;

/**
 * @author : fengkun
 * @date : 20-5-25
 * 内容 ： SingletonDemo（单例模式） DCL（双端检锁）
 */
public class SingletonDemo {

  private SingletonDemo() {
    System.out.println(Thread.currentThread().getName() + "\t SingletonDemo");
  }

  private static volatile SingletonDemo instance = null;

  private static SingletonDemo getInstance() {

    if (instance == null) {
      // 同步代码的时候，进行检测
      synchronized (SingletonDemo.class) {
        if (instance == null) {
          instance = new SingletonDemo();
        }
      }
    }
    return instance;
  }

  public static void main(String[] args) {

    // 这里的 == 是比较内存地址
    /*System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
    System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
*/
    // 多线程下
    for (int i = 0; i < 1000; i++) {

      new Thread(() -> {
        SingletonDemo.getInstance();
      }, String.valueOf(i)).start();
    }
  }
}
