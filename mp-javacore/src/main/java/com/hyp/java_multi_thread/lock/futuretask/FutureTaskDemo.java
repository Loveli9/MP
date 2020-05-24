package com.hyp.java_multi_thread.lock.futuretask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by sherry on 17/1/6.
 */
public class FutureTaskDemo {

    /**
     * 日志
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        // 创建线程池并返回ExecutorService实例
        List<FutureTask<String>> list = new ArrayList<>();

        //异步添加任务
        for (int i = 0; i < 10; i++) {
            MyCallable callable = new MyCallable(1000);                       // 要执行的任务
            FutureTask<String> futureTask = new FutureTask<String>(callable);
            executor.submit(futureTask);
            System.out.println("-----添加-----："+i);
            list.add(futureTask);
        }

        //顺序打印执行结果
        for (FutureTask<String> futureTask:list){
            System.out.println(futureTask.get());
        }
        executor.shutdown();
    }
}

/**
 * 线程任务类
 */
class MyCallable implements Callable<String> {
    private long waitTime;

    public MyCallable(int timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}
