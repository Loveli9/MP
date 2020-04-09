package com.hyp.java_multi_thread.achieve_thread;

public class Java8ThreadTest {

    public static void main(String[] args) {
        new Thread(() -> {
            for(int i=0;i<10;i++) {
                System.out.println("Lambda表达式简化线程实现");
            }
        }).start();
    }

}
