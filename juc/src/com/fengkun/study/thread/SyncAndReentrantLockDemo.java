package com.fengkun.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : fengkun
 * @date : 20-6-3
 * 内容 ： 题目：多线程之前顺序调用，实现A-B-C三个线程启动，要求如下：
 * AA 打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA 打印5次，BB打印10次，CC打印15次
 * 。。。。
 * 10轮
 */
public class SyncAndReentrantLockDemo {

  public static void main(String[] args) {

    ShareResource shareResource = new ShareResource();

    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        shareResource.print5();
      }
    }, "A").start();

    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        shareResource.print10();
      }
    }, "B").start();

    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        shareResource.print15();
      }
    }, "C").start();
  }
}

class ShareResource {

  private int number = 1; // A:1 B:2 C:3
  private Lock lock = new ReentrantLock();
  private Condition condition1 = lock.newCondition();
  private Condition condition2 = lock.newCondition();
  private Condition condition3 = lock.newCondition();

  public void print5() {

    // 同步代码块，加锁
    lock.lock();
    try {

      //判断　不是１的情况等待
      while (number != 1) {
        condition1.await();
      }

      for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + "\t" + i);
      }

      number = 2;

      condition2.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print10() {

    // 同步代码块，加锁
    lock.lock();
    try {

      //判断　不是１的情况等待
      while (number != 2) {
        condition2.await();
      }

      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + "\t" + i);
      }

      number = 3;

      condition3.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print15() {

    // 同步代码块，加锁
    lock.lock();
    try {

      //判断　不是１的情况等待
      while (number != 3) {
        condition3.await();
      }

      for (int i = 0; i < 15; i++) {
        System.out.println(Thread.currentThread().getName() + "\t" + i);
      }

      number = 1;

      condition1.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

}
