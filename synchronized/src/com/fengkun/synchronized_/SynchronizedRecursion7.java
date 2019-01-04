package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-3
 * 内容 ： 可重入锁 - 递归调用本方法
 */
public class SynchronizedRecursion7 {

    int i = 0;

    public static void main(String[] args) {
        SynchronizedRecursion7 object = new SynchronizedRecursion7();
        object.method1();
    }

    private synchronized void method1() {
        System.out.println("i = " + i);
        if (i == 0) {
            i++;
            method1();
        }

    }
}
