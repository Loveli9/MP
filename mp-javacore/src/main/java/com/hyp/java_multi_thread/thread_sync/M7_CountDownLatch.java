package com.hyp.java_multi_thread.thread_sync;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class M7_CountDownLatch {

    /**
     * CountDownLatch是一个同步的辅助类，允许一个或多个线程，
     * 等待其他一组线程完成操作，再继续执行。
     * 他类实际上是使用计数器的方式去控制的
     * */
    public static void main(String[] args) {
        //启动两个线程，分别执行完毕之后再执行主线程
        CountDownLatch countDownLatch = new CountDownLatch(2);

        //线程1执行
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            countDownLatch.countDown();
        });
        //线程2执行
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程执行完毕");
            countDownLatch.countDown();
        });


        thread1.start();
        thread2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //执行主线程
        System.out.println("主线程执行完毕");
    }
}
