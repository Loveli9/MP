package com.hyp.java_multi_thread.thread_sync;

import java.util.concurrent.ArrayBlockingQueue;

public class M3_ArrayBlockingQueue {

    public static void main(String[] args) {
        Man man = new Man();

        new Thread(() -> {
            man.getRunnable1();
        }).start();
        new Thread(() -> {
            man.getRunnable2();
        }).start();
    }

    public static class Man {

        ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(1);

        public void getRunnable1() {
            for (int i = 0; i < 8; i++) {
                System.out.println("生产出：" + i + "个");
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("---------------生产完毕-----------------");
        }

        public void getRunnable2() {
            for (int i = 0; i < 8; i++) {
                try {
                    int num = (int) queue.take();
                    System.out.println("取出出：" + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
