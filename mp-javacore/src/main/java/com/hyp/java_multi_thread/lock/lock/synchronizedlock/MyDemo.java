package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

public class MyDemo {

    public static void main(String[] args) {
        MySyncThread syncThread = new MySyncThread();
        Thread thread1 = new Thread(syncThread, "线程1");
        Thread thread2 = new Thread(syncThread, "线程2");
        thread1.start();
        thread2.start();
    }

}

/**
 * 同步线程
 */
class MySyncThread implements Runnable {

    private static int count;
    private static final Object obj = new Object();
    public MySyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + "：" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

}

