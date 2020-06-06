package com.fengkun.study.thread;

import java.util.concurrent.*;

/**
 * @author : fengkun
 * @date : 20-6-5
 * 内容 ： 第四种获取 / 使用 Java多线程的方式，通过线程池
 */
public class MyThreadPoolDemo {

  public static void main(String[] args) {

    // Array  Arrays(辅助工具类)
    // Collection Collections(辅助工具类)
    // Executor Executors(辅助工具类)
    // 手写线程池
    final Integer corePoolSize = 2;
    final Integer maximumPoolSize = 5;
    final Long keepAliveTime = 1L;

    ExecutorService threadPool = new ThreadPoolExecutor(
        corePoolSize,
        maximumPoolSize,
        keepAliveTime,
        TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(3),
        Executors.defaultThreadFactory(),
        new ThreadPoolExecutor.CallerRunsPolicy()
    );

    try {
      // 循环十次，模拟业务办理，让5个线程处理这10个请求
      for (int i = 0; i < 9; i++) {
        threadPool.execute(() -> {
          System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
          try {
            TimeUnit.SECONDS.sleep(1);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      threadPool.shutdown();
    }
  }

  private static void threadPoolInit() {
    // 一池5个处理线程（用池化技术，一定要记得关闭）
//    ExecutorService threadPool = Executors.newFixedThreadPool(5);
//      ExecutorService threadPool = Executors.newSingleThreadExecutor();
    ExecutorService threadPool = Executors.newCachedThreadPool();

    // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
    try {
      // 循环十次，模拟业务办理，让5个线程处理这10个请求
      for (int i = 0; i < 20; i++) {
        threadPool.execute(() -> {
          System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
        });
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      threadPool.shutdown();
    }
  }
}
