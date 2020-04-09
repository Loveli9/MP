package com.hyp.java_multi_thread.threadPool.classicPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池
 * */
public class FixedThreadPoolTest {

    public static void main(String[] args) {
        System.out.println("CPU核心数：" + Runtime.getRuntime().availableProcessors());
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "，index：" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
