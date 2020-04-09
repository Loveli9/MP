package com.hyp.java_multi_thread.lock.reentrant;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLock unFairLock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new TestThread(fairLock,i," 公平锁"));
            threadPool.submit(new TestThread(unFairLock, i, " 非公平锁"));
        }
    }

    static class TestThread implements Runnable {
        Lock lock;
        int indext;
        String tag;

        public TestThread(Lock lock, int index, String tag) {
            this.lock = lock;
            this.indext = index;
            this.tag = tag;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId() + " 线程 START  " + tag);
            meath();
        }

        private void meath() {
            lock.lock();
            try {
                if((indext & 0x1) == 1){
                    Thread.sleep(200);
                }else{
                    Thread.sleep(500);
                }
                System.out.println(Thread.currentThread().getId() + " 线程 获得： Lock  ---》" + tag + "  Index:" + indext);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    private void alternateTask() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 65; i < 91; i++) {
                    System.out.println("----------thread1------- " + (char) i);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 26; i++) {
                    System.out.println("----------thread2------- " + i);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }

    @Test
    public void testLock() {
        alternateTask();
    }



}
