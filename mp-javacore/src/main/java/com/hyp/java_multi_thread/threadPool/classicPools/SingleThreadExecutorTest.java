package com.hyp.java_multi_thread.threadPool.classicPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程池
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。示例代码如下：
 * */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("当前线程：" + Thread.currentThread().getName() + "，index=" + index);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
