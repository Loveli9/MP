package com.hyp.java_multi_thread.lock.lock.reentrantlock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ParkTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sayHello();
            }
        });
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main----1");
        LockSupport.unpark(t1);
    }

    private static void sayHello() {
        System.out.println("t1------1");
//        System.out.println("t1------1" + Thread.currentThread().getName() );
        LockSupport.park();
        System.out.println("t1------2");
    }

}
