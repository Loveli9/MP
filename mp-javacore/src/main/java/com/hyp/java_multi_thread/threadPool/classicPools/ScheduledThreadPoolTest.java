package com.hyp.java_multi_thread.threadPool.classicPools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 周期线程池
 * */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName() + "延迟1秒，然后每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    public static void test2() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName() + "延迟3秒");
            }
        }, 3, TimeUnit.SECONDS);
    }

    public static void test3() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName() + "延迟3秒");
            }
        }, 3,1, TimeUnit.SECONDS);
    }

}
