package com.fengkun.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : fengkun
 * @date : 20-6-3
 * 内容 ： BlockingQueue
 */
public class BlockingQueueDemo {

  public static void main(String[] args) throws Exception {

//    List list = null;
    //　阻塞队列，需要填入默认值　
    offerPoll();
  }

  /**
   * 超时组
   *
   * @throws InterruptedException
   */
  private static void offerPoll() throws InterruptedException {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    /**
     * 使用offer插入的时候，需要指定时间，如果2秒还没有插入，那么就放弃插入
     */
    System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));

    /**
     * 如果2秒内取不出来，那么就返回null
     */
    System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
  }

  /**
   * 阻塞队列组
   *
   * @throws InterruptedException
   */
  private static void putTake() throws InterruptedException {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    blockingQueue.put("a");
    blockingQueue.put("b");
    blockingQueue.put("c");
    System.out.println("================");

    blockingQueue.take();
    blockingQueue.take();
    blockingQueue.take();
    blockingQueue.take();
  }

  /**
   * 布尔类型组
   */
  private static void booleanQueue() {
    BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

    System.out.println(blockingQueue.offer("a"));
    System.out.println(blockingQueue.offer("b"));
    System.out.println(blockingQueue.offer("c"));
    System.out.println(blockingQueue.offer("d"));

    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
    System.out.println(blockingQueue.poll());
  }

  /**
   * 抛出异常组
   */
  private static void addRemove() {
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
    System.out.println(blockingQueue.add("a"));
    System.out.println(blockingQueue.add("b"));
    System.out.println(blockingQueue.add("c"));

    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
    System.out.println(blockingQueue.remove());
  }
}
