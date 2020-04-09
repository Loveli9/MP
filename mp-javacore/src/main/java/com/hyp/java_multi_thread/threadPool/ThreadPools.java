package com.hyp.java_multi_thread.threadPool;

import java.util.concurrent.*;

public class ThreadPools {

    //适用场景：可用于Web服务瞬时削峰，但需注意长时间持续高峰情况造成的队列阻塞。
    //corePoolSize与maximumPoolSize相等，即其线程全为核心线程，是一个固定大小的线程池，是其优势；
    //keepAliveTime = 0 该参数默认对核心线程无效，而FixedThreadPool全部为核心线程；
    //workQueue 为LinkedBlockingQueue（无界阻塞队列），队列最大值为Integer.MAX_VALUE。
    //如果任务提交速度持续大余任务处理速度，会造成队列大量阻塞。因为队列很大，很有可能在拒绝策略前，内存溢出。是其劣势；
    //FixedThreadPool的任务执行是无序的；
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    //适用场景：快速处理大量耗时较短的任务，如Netty的NIO接受请求时，可使用CachedThreadPool。
    //corePoolSize = 0，maximumPoolSize = Integer.MAX_VALUE，即线程数量几乎无限制；
    //keepAliveTime = 60s，线程空闲60s后自动结束。
    //workQueue 为 SynchronousQueue 同步队列，这个队列类似于一个接力棒，入队出队必须同时传递，因为CachedThreadPool线程创建无限制，
    //不会有队列等待，所以使用SynchronousQueue；
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue());
//                new SynchronousQueue<Runnable>());
    }

    //SingleThreadExecutor
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    public static void main(String[] args) {
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(1);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) fixedExecutorService;
        System.out.println(threadPoolExecutor.getMaximumPoolSize());
        threadPoolExecutor.setCorePoolSize(8);
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
    }


}
