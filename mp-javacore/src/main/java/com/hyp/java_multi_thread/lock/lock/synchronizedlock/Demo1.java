package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

/**
 * 一个线程访问一个对象中的synchronized(this)同步代码块时，
 * 其他试图访问该对象的线程将被阻塞。我们看下面一个例子：
 * */
public class Demo1 {

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "线程1");
        Thread thread2 = new Thread(syncThread, "线程2");
        thread1.start();
        thread2.start();

//        SyncThread syncThread1 = new SyncThread();
//        SyncThread syncThread2 = new SyncThread();
//        Thread thread1 = new Thread(syncThread1, "SyncThread1");
//        Thread thread2 = new Thread(syncThread2, "SyncThread2");
//        thread1.start();
//        thread2.start();
    }

}

/**
 * 同步线程
 */
class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized(this) {
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