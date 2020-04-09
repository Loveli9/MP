package com.hyp.java_multi_thread.lock;

/**
 * ssynchronized是属于非公平锁
 * */
public class SynchronizedTest {

    public static synchronized void test() {
        for(int i=0;i<20;i++){
            int finalI = i;
            new Thread(() ->
                    test(finalI)
            ).start();
        }
    }
    synchronized private static void test(int index) {
        System.out.println("--------------- > Task :" + index);
    }

    public static void main(String[] args) {
        test();
    }

}
