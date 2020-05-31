package com.hyp.java_multi_thread.lock.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写写互斥
 * */
public class WriteWriteTask {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "：start");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "：end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        final WriteWriteTask myTask = new WriteWriteTask();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                myTask.write();
            }
        });
        t1.setName("t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                myTask.write();
            }
        });
        t2.setName("t2");

        t1.start();
        t2.start();
    }

}
