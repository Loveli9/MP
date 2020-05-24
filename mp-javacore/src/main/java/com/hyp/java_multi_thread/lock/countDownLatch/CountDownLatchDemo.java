package com.hyp.java_multi_thread.lock.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        // Let us create task that is going to
        // wait for four threads before it starts
        CountDownLatch latch = new CountDownLatch(3);

        long start = System.currentTimeMillis();
        System.out.println("start====" + start);
        // Let us create four worker
        // threads and start them.
        WorkerThread first = new WorkerThread(2000, latch, "worker-1");
        WorkerThread second = new WorkerThread(4000, latch, "worker-2");
        WorkerThread third = new WorkerThread(6000, latch, "worker-3");
        WorkerThread four = new WorkerThread(8000, latch, "worker-3");

        first.start();
        second.start();
        third.start();
        four.start();

        // The main task waits for four threads
        latch.await();
        latch.await(3000, TimeUnit.MILLISECONDS);
        long end = System.currentTimeMillis();
        System.out.println("end===" + end);
        // Main thread has started
        System.out.println(Thread.currentThread().getName() + " has finished. Spend Time = " + (System.currentTimeMillis() - start));
    }

    // A class to represent threads for which
    // the main thread waits.
    static class WorkerThread extends Thread {

        private int delay;
        private CountDownLatch latch;

        public WorkerThread(int delay, CountDownLatch latch, String name) {
            super(name);
            this.delay = delay;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
