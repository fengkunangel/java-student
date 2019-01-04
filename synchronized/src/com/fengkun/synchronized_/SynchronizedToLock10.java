package com.fengkun.synchronized_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : fengkun
 * @date : 19-1-4
 * 内容 ：
 */
public class SynchronizedToLock10 {

    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("synchronized");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("lock");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock10 s = new SynchronizedToLock10();
        s.method1();
        s.method2();
    }
}
