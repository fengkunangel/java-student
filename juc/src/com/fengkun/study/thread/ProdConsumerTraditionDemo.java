package com.fengkun.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : fengkun
 * @date : 20-6-3
 * 内容 ： 生产者消费者 传统版
 * 题目：一个初始值为0的变量，两个线程对其交替操作，一个加1，一个减1，来5轮
 */
public class ProdConsumerTraditionDemo {

  public static void main(String[] args) {

    // 高内聚，低耦合    内聚指的是，一个空调，自身带有调节温度高低的方法

    ShareData shareData = new ShareData();

    // t1线程，生产
    new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        try {
          shareData.increment();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }, "t1").start();

    // t2线程，消费
    new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        try {
          shareData.decrement();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }, "t2").start();
  }
}

/**
 * 资源类
 */
class ShareData {

  private int number = 0;

  private Lock lock = new ReentrantLock();

  private Condition condition = lock.newCondition();

  public void increment() throws Exception {
    // 同步代码块，加锁
    lock.lock();
    try {

      //判断　有值的情况，不能生产
      while (number != 0) {
        condition.await();
      }

      number++;

      System.out.println(Thread.currentThread().getName() + "\t" + number);

      condition.signalAll();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void decrement() throws Exception {
    // 同步代码块，加锁
    lock.lock();
    try {
      // 判断
      while (number == 0) {
        // 等待不能消费
        condition.await();
      }

      // 干活
      number--;

      System.out.println(Thread.currentThread().getName() + "\t " + number);

      // 通知 唤醒
      condition.signalAll();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}