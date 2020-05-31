package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

public class Demo6 {

    public static void main(String[] args) {
        SyncThread6 syncThread1 = new SyncThread6();
        SyncThread6 syncThread2 = new SyncThread6();
        Thread thread1 = new Thread(syncThread1, "线程1");
        Thread thread2 = new Thread(syncThread2, "线程2");
        thread1.start();
        thread2.start();
    }

}

/**
 * 同步线程
 */
class SyncThread6 implements Runnable {
    private static int count;

    public SyncThread6() {
        count = 0;
    }

    public static void method() {
        synchronized(SyncThread.class) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }
}
