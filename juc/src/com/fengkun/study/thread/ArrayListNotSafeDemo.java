package com.fengkun.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : fengkun
 * @date : 20-5-28
 * 内容 ： 集合类线程不安全举例
 */
public class ArrayListNotSafeDemo {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        list.add(UUID.randomUUID().toString().substring(0, 8));
        System.out.println(list);
      }, String.valueOf(i)).start();
    }
  }
}
