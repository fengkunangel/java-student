package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-3
 * 内容 ： 可重入锁 - 调用类内其它的方法
 */
public class SynchronizedOtherMethod8 {

    public synchronized void method1() {
        System.out.println("method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println("method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod8 object = new SynchronizedOtherMethod8();
        object.method1();
    }
}
