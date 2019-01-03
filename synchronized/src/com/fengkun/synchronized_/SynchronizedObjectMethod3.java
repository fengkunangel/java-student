package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-2
 * 内容 ： 对象锁-方法锁
 */
public class SynchronizedObjectMethod3 implements Runnable{

    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

    @Override
    public void run() {
        methon();
    }

    public synchronized void methon() {
        System.out.println("方发锁，name: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": finished");

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
