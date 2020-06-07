package com.fengkun.study.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： GC 回收超时
 * * JVM参数配置: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class GCOverheadLimitDemo {

  public static void main(String[] args) {
    int i = 0;
    List<String> list = new ArrayList<>();
    try {
      while (true) {
        list.add(String.valueOf(++i).intern());
      }
    } catch (Exception e) {
      System.out.println("***************i:" + i);
      e.printStackTrace();
      throw e;
    } finally {

    }
  }
}
