package com.hyp.java_multi_thread.achieve_thread;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();//创建实例
        myThread.start();//启动线程
        for (int i = 0;i < 20;i++) {
            System.out.println("一边敲代码");
        }
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0;i < 20;i++) {
            System.out.println("一边听歌");
        }
    }
}
