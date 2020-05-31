package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

public class SyncTest2 implements Runnable{

    //共享资源变量
    int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"：" + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncTest2 syncTest1 = new SyncTest2();
        SyncTest2 syncTest2 = new SyncTest2();
        Thread thread1 = new Thread(syncTest1,"线程1");
        Thread thread2 = new Thread(syncTest2, "线程2");
        thread1.start();
        thread2.start();
    }

}
