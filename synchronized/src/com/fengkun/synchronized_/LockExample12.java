package com.fengkun.synchronized_;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : fengkun
 * @date : 19-1-4
 * 内容 ： Lock方法
 */
public class LockExample12 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
//        lock.tryLock(1000, TimeUnit.SECONDS);
    }
}
