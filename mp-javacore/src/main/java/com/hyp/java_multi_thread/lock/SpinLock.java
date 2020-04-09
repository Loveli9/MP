package com.hyp.java_multi_thread.lock;

import java.util.Random;

/**
 * 自旋锁
 * */
public class SpinLock {

    public synchronized void a() {
        System.out.println("a...");
        b();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized void b() {
        System.out.println("b...");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行...");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕...");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行...");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕...");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程开始执行...");
                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕...");
            }
        }).start();

        while(Thread.activeCount() != 1) {

        }
        System.out.println("所有的线程执行完毕...");
    }

}
