package com.hyp.java_multi_thread.lock.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    static class TaskThread extends Thread {

        Semaphore semaphore;

        public TaskThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(getName() + " acquire");
                System.out.println("睡眠两秒...");
                Thread.sleep(2000);
                semaphore.release();
                System.out.println(getName() + " release ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < threadNum; i++) {
            new TaskThread(semaphore).start();
        }
    }

}