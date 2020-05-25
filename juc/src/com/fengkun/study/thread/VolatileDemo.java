package com.fengkun.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : fengkun
 * @date : 20-5-24
 * 内容 ：  Volatile Java虚拟机提供的轻量级同步机制
 * 可见性（及时通知）
 * 不保证原子性
 * 禁止指令重排
 */
public class VolatileDemo {

  public static void main(String[] args) {

    Mydata mydata = new Mydata();

    // 创建10个线程，线程里面进行1000次循环
    for (int i = 0; i < 20; i++) {
      new Thread(() -> {

        for (int j = 0; j < 1000; j++) {
          mydata.addPlusPlus();
          mydata.addAtomic();
        }
      }, String.valueOf(i)).start();
    }

    // 需要等待上面20个线程都计算完成后，在用main线程取得最终的结果值
    // 这里判断线程数是否大于2，为什么是2？因为默认是有两个线程的，一个main线程，一个gc线程
    while (Thread.activeCount() > 2) {
      // yield表示不执行
      Thread.yield();
    }

    // 查看最终的值
    // 假设volatile保证原子性，那么输出的值应该为：  20 * 1000 = 20000
    System.out.println(Thread.currentThread().getName() + "\t finally number value: " + mydata.number);
    System.out.println(Thread.currentThread().getName() + "\t finally atomicNumber value: " + mydata.atomicInteger);
  }

  // ctrl + alt + m 提取代码到方法
  // volatile 可以保证可见性，及时通知其它线程，主物理内存的值被修改
  private static void seeOkByVolatile() {
    // 资源类
    Mydata mydata = new Mydata();

    // AAA 线程
    new Thread(() -> {

      System.out.println(Thread.currentThread().getName() + "\t come in");

      // 线程sleep 3秒，假设在进行业务
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 修改number的值
      mydata.addTo60();

      // 输出修改后的值
      System.out.println(Thread.currentThread().getName() + "\t update number value:" + mydata.number);

    }, "AAA").start();

    while (mydata.number == 0) {
      // main线程就一直在这里等待循环，直到number的值不等于零
    }

    // 按道理这个值是不可能打印出来的，因为主线程运行的时候，number的值为0，所以一直在循环
    // 如果能输出这句话，说明AAA线程在睡眠3秒后，更新的number的值，重新写入到主内存，并被main线程感知到了
    System.out.println(Thread.currentThread().getName() + "\t mission is over");
  }
}

class Mydata {

  // 加volatile 先后对比
  volatile int number = 0;

  public void addTo60() {
    this.number = 60;
  }

  /**
   * 注意，此时number 前面是加了volatile修饰
   */
  public void addPlusPlus() {
    number++;
  }

  /**
   * 创建一个原子Integer包装类，默认为0
   */
  AtomicInteger atomicInteger = new AtomicInteger();

  public void addAtomic() {
    // 相当于 atomicInter ++
    atomicInteger.getAndIncrement();
  }
}
