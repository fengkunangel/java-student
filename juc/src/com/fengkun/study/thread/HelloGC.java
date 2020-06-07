package com.fengkun.study.thread;

/**
 * @author : fengkun
 * @date : 20-6-6
 * 内容 ： 查看运行的Java程序，JVM参数是否开启，具体值为多少？o
 */
public class HelloGC {

  public static void main(String[] args) throws InterruptedException {
    // 返回Java虚拟机中内存的总量
    long totalMemory = Runtime.getRuntime().totalMemory();

    // 返回Java虚拟机中试图使用的最大内存量
    long maxMemory = Runtime.getRuntime().maxMemory();

    System.out.println("TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)、" + (totalMemory / (double) 1024 / 1024) + "MB");
    System.out.println("MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");

    Thread.sleep(Integer.MAX_VALUE);

  }
}
