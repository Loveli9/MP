package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

public class Demo5 {

    public static void main(String[] args) {
        SyncThread5 syncThread1 = new SyncThread5();
        SyncThread5 syncThread2 = new SyncThread5();
        Thread thread1 = new Thread(syncThread1, "线程1");
        Thread thread2 = new Thread(syncThread2, "线程2");
        thread1.start();
        thread2.start();
    }

}

/**
 * 同步线程
 */
class SyncThread5 implements Runnable {
    private static int count;

    public SyncThread5() {
        count = 0;
    }

    /** synchronized修饰静态方法 **/
    /** synchronized修饰的静态方法锁定的是这个类的所有对象 **/
    @Override
    public synchronized void run() {
        method();
    }

    public synchronized static void method() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + "：" + (count++));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}