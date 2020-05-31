package com.hyp.java_multi_thread.lock.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sayHello();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sayHello();
            }
        });
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    private static void sayHello() {
        reentrantLock.lock();
        System.out.println("Hello：" + Thread.currentThread().getName() );
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
