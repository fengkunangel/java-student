package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-3
 * 内容 ： 可重入锁 - 调用父类的方法
 */
public class SynchronizedSuperClass9 {
    public synchronized void doSomething() {
        System.out.println("Super");
    }
}

class TestClass extends SynchronizedSuperClass9 {

    public synchronized void doSomething() {
        System.out.println("Test");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass t = new TestClass();
        t.doSomething();
    }

}
