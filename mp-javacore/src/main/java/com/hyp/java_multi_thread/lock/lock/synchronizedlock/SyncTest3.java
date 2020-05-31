package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

public class SyncTest3 implements Runnable {
    //共享资源变量
    static int count = 0;

    @Override
    public synchronized void run() {
        increaseCount();
    }

    /** synchronized修饰的静态方法锁定的是这个类的所有对象 **/
    private synchronized static void increaseCount() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + count++);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncTest3 syncTest1 = new SyncTest3();
        SyncTest3 syncTest2 = new SyncTest3();
        Thread thread1 = new Thread(syncTest1, "线程1");
        Thread thread2 = new Thread(syncTest2, "现程2");
        thread1.start();
        thread2.start();
    }

}