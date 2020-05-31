package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

import org.junit.Test;

public class SyncTest1 implements Runnable{

    //共享资源变量
    int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            count++;
            System.out.println(Thread.currentThread().getName()+"："+count);
        }
    }

    public static void main(String[] args) {
//        SyncTest1 syncTest = new SyncTest1();
//        Thread thread1 = new Thread(syncTest,"线程1");
//        Thread thread2 = new Thread(syncTest, "线程2");
//        thread1.start();
//        thread2.start();

        /** 锁住方法其实是锁住方法的对象，如果有两个任务，不能线程同步 **/
        SyncTest1 syncTest1 = new SyncTest1();
        SyncTest1 syncTest2 = new SyncTest1();
        Thread thread1 = new Thread(syncTest1,"线程1");
        Thread thread2 = new Thread(syncTest2, "线程2");
        thread1.start();
        thread2.start();
    }

}
