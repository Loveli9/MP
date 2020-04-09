package com.hyp.java_multi_thread.lock;

/**
 * 死锁
 **/
public class DeadLock {

    private Object obj1 = new Object();
    private Object obj2 = new Object();

    public void a() {
        synchronized (obj1)  {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (obj2)  {
                System.out.println("a");
            }
        }
    }

    public void b() {
        synchronized (obj2)  {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (obj1)  {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.b();
            }
        }).start();
    }

}
