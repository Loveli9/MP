package com.hyp.java_multi_thread.achieve_thread;

public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        for (int i = 0;i < 10;i++) {
            System.out.println("一边敲代码：" + i);
        }
    }
}


class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0;i < 10;i++) {
            System.out.println("一边听歌：" + i);
        }
    }
}

