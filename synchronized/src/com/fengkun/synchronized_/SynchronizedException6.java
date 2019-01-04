package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-3
 * 内容 ： 方法抛出异常后，会释放锁
 */
public class SynchronizedException6 implements Runnable {

    static SynchronizedException6 instance = new SynchronizedException6();

    public synchronized void method1() {
        System.out.println("方法锁，name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": finished");
    }

    public synchronized void method2() {
        System.out.println("方法锁，name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": finished");
    }



    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
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
