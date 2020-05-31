package com.hyp.java_multi_thread.lock.lock.synchronizedlock;

public class SyncTest4 implements Runnable {

    //共享资源变量
    static int count = 0;
    private byte[] mBytes = new byte[0];

    @Override
    public void run() {
        increaseCount();
    }

    private void increaseCount() {
        //假设省略了其他操作的代码。
        //……………………
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + count++);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncTest4 syncTest1 = new SyncTest4();
        SyncTest4 syncTest2 = new SyncTest4();
        Thread thread1 = new Thread(syncTest1, "线程1");
        Thread thread2 = new Thread(syncTest1, "线程2");
//        Thread thread2 = new Thread(syncTest2, "线程2");
        thread1.start();
        thread2.start();
    }

}
