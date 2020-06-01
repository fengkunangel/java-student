package com.fengkun.study.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : fengkun
 * @date : 20-6-1
 * 内容 ： 可重入锁（也叫递归锁）
 * * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取到该锁的代码，在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * *
 * * 也就是说：`线程可以进入任何一个它已经拥有的锁所同步的代码块`
 */
public class ReenterLockDemo {

  public static void main(String[] args) {

    Phone phone = new Phone();

    // 两个线程操作资源类
    /*new Thread(() -> {
      try {
        phone.sendSMS();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }, "t1").start();

    new Thread(() -> {
      try {
        phone.sendSMS();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }, "t2").start();*/

    Thread t3 = new Thread(phone, "t3");
    Thread t4 = new Thread(phone, "t4");

    t3.start();
    t4.start();

  }
}

class Phone implements Runnable {

  /**
   * 发送短信
   *
   * @throws Exception
   */
  public synchronized void sendSMS() throws Exception {
    System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS()");

    // 在同步方法中，调用另外一个同步方法
    sendEmail();
  }

  /**
   * 发邮件
   *
   * @throws Exception
   */
  public synchronized void sendEmail() throws Exception {
    System.out.println(Thread.currentThread().getName() + "\t invoked sendEmail()");
  }

  Lock lock = new ReentrantLock();

  @Override
  public void run() {
    getLock();
  }

  /**
   * set进去的时候，就加锁，调用set方法的时候，能否访问另外一个加锁的set方法
   */
  public void getLock() {
    lock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + "\t get Lock");
      setLock();
    } finally {
      lock.unlock();
    }
  }

  public void setLock() {
    lock.lock();
    try {
      System.out.println(Thread.currentThread().getName() + "\t set Lock");
    } finally {
      lock.unlock();
    }
  }
}