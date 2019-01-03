package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-2
 * 内容 ： 对象锁-代码块
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {

        synchronized (lock1) {
            System.out.println("lock1: " + Thread.currentThread().getName() + " -start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock1: " + Thread.currentThread().getName() + " -finished");
        }

        synchronized (lock2) {
            System.out.println("lock2: " + Thread.currentThread().getName() + " -start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2: " + Thread.currentThread().getName() + " -finished");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
