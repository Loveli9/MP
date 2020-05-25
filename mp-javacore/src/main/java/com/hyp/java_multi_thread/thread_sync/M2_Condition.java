package com.hyp.java_multi_thread.thread_sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class M2_Condition {

    public static boolean flag = false;

    public static int num = 0;

    /**
     * condition 的wait和signal
     * */
    public static void main(String[] args) {
        Man man = new Man();

        new Thread(() -> {
            man.getRunnable1();
        }).start();
        new Thread(() -> {
            man.getRunnable2();
        }).start();
    }

    public static class Man {
        public static ReentrantLock lock = new ReentrantLock();
        public static Condition condition = lock.newCondition();

        public void getRunnable1() {
            lock.lock();
            try {
                for (int i = 0; i < 20; i++) {
                    while (flag) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("生产出：" + (++num) + "个");
                    flag = true;
                    condition.signal();
                }
            } finally {
                lock.lock();
            }
        }

        public void getRunnable2() {
            lock.lock();
            try {
                for (int i = 0; i < 20; i++) {
                    while (!flag) {
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("取出出：" + (num--) + "个");
                    System.out.println("------------------");
                    flag = false;
                    condition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }


}
