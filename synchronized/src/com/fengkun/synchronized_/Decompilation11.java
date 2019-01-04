package com.fengkun.synchronized_;

/**
 * @author : fengkun
 * @date : 19-1-4
 * 内容 ： 反编译字节码
 *       javac Decompilation11.java
 *      javap -verbose  Decompilation11.class
 */
public class Decompilation11 {

    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (object) {

        }
    }
}
