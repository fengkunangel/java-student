package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-2
 * 内容 ：
 */
public class SynchronizedClassClass5 implements Runnable {

    static SynchronizedClassClass5 instance1 = new SynchronizedClassClass5();
    static SynchronizedClassClass5 instance2 = new SynchronizedClassClass5();

    @Override
    public void run() {
        method();
    }

    private void method() {
        synchronized (SynchronizedClassClass5.class) {
            System.out.println("类锁，name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": finished");
        }
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
