package com.fengkun.study.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : fengkun
 * @date : 20-6-3
 * 内容 ： SynchronousQueue没有容量，与其他BlockingQueue不同，SynchronousQueue是一个不存储的BlockingQueue，每一个put操作必须等待一个take操作，否者不能继续添加元素
 */
public class SynchronousQueueDemo {

  public static void main(String[] args) {

    BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

    new Thread(() -> {
      try {
        System.out.println(Thread.currentThread().getName() + "\t put A ");
        blockingQueue.put("A");

        System.out.println(Thread.currentThread().getName() + "\t put B ");
        blockingQueue.put("B");

        System.out.println(Thread.currentThread().getName() + "\t put C ");
        blockingQueue.put("C");

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "t1").start();

    new Thread(() -> {
      try {

        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        blockingQueue.take();
        System.out.println(Thread.currentThread().getName() + "\t take A ");

        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        blockingQueue.take();
        System.out.println(Thread.currentThread().getName() + "\t take B ");

        try {
          TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        blockingQueue.take();
        System.out.println(Thread.currentThread().getName() + "\t take C ");

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "t2").start();

  }
}
