package com.hyp.java_multi_thread.lock.lock.reentrantreadwritelock;

/**
 * 写读互斥
 * */
public class WriteReadTask {

    public static void main(String[] args) {

        final ReadWriteTask myTask = new ReadWriteTask();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                myTask.write();
            }
        });
        t1.setName("t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                myTask.read();
            }
        });
        t2.setName("t2");

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
