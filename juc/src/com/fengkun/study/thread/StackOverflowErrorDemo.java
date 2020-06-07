package com.fengkun.study.thread;

/**
 * @author : fengkun
 * @date : 20-6-7
 * 内容 ： 堆栈溢出，我们有最简单的一个递归调用，就会造成堆栈溢出，也就是深度的方法调用
 */
public class StackOverflowErrorDemo {

  public static void main(String[] args) {
    stackOverflowError();
  }
  /**
   * 栈一般是512K，不断的深度调用，直到栈被撑破
   * Exception in thread "main" java.lang.StackOverflowError
   */
  private static void stackOverflowError() {
    stackOverflowError();
  }
}
