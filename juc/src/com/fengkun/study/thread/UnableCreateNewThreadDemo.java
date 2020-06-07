package com.fengkun.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 不能够创建更多的新的线程了，也就是说创建线程的上限达到了
 * <p>
 * 在高并发场景的时候，会应用到
 * <p>
 * 高并发请求服务器时，经常会出现如下异常java.lang.OutOfMemoryError:unable to create new native thread，准确说该native thread异常与对应的平台有关
 * 导致原因：
 * 应用创建了太多线程，一个应用进程创建多个线程，超过系统承载极限
 * 服务器并不允许你的应用程序创建这么多线程，linux系统默认运行单个进程可以创建的线程为1024个，如果应用创建超过这个数量，就会报 java.lang.OutOfMemoryError:unable to create new native thread
 */
public class UnableCreateNewThreadDemo {

  public static void main(String[] args) {
    for (int i = 0; ; i++) {
      System.out.println("************** i = " + i);
      new Thread(() -> {
        try {
          TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }, String.valueOf(i)).start();
    }
  }
}
