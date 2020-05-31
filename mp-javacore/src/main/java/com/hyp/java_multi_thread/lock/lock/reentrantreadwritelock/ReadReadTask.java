package com.hyp.java_multi_thread.lock.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读读共享
 * */
public class ReadReadTask {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "：start");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "：end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        final ReadReadTask myTask = new ReadReadTask();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myTask.read();
            }
        });
        t1.setName("t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myTask.read();
            }
        });
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}

