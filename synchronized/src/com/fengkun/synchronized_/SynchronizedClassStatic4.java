package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-2
 * 内容 ： 类锁-static
 */
public class SynchronizedClassStatic4 implements Runnable {

    static SynchronizedClassStatic4 instance1 = new SynchronizedClassStatic4();

    static SynchronizedClassStatic4 instance2 = new SynchronizedClassStatic4();

    public static synchronized void method() {
        System.out.println("类锁，name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": finished");
    }

    @Override
    public void run() {
        method();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
