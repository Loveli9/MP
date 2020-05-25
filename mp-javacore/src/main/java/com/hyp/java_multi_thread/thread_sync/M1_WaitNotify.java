package com.hyp.java_multi_thread.thread_sync;

public class M1_WaitNotify {

    public static boolean flag = false;

    public static int num = 0;

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

        public synchronized void getRunnable1() {
            for (int i = 0; i < 20; i++) {
                while (flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("生产出：" + (++num) + "个");
                flag = true;
                notify();
            }
        }

        public synchronized void getRunnable2() {
            for (int i = 0; i < 20; i++) {
                while (!flag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //模拟加载时间
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("取出出：" + (num--) + "个");
                System.out.println("------------------");

                flag = false;
                notify();
            }
        }
    }



}


