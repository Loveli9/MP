package com.hyp.java_multi_thread.thread_sync;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class M5_SynchronousQueue {

    /**
     * 使用阻塞队列SynchronousQueue
     * offer将数据插入队尾
     * take取出数据，如果没有则阻塞，直到有数据在获取到
     */
    @Test
    public void test() {
        SynchronousQueue queue = new SynchronousQueue();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    queue.offer(9);
                    System.out.println("offer===" + 9);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            int take = (int) queue.take();
            System.out.println("take===" + take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
