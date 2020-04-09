package com.hyp.java_multi_thread.example.ex5;

/**
 * 六．示例五：设计四个线程对象对同一个数据进行操作，两个线程执行减操作，两个线程执行加操作。
 * 程序分析：
 * 1.创建一个ThreadAddSub类继承Thread，重写run方法
 * 2.在run方法里面实现加和减的操作，每次操作后睡眠1秒
 * 3.创建主方法调用类
 * */
public class ThreadAddSub extends Thread {

    //判断要进行的操作
    boolean operate = true;
    //要操作的数
    static int sum = 0;

    // 把操作运算通过构造方法传进来
    public ThreadAddSub(boolean operate) {
        super();
        this.operate = operate;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            if (operate) {
                sum+=5;
                System.out.println("加后，sum="+sum);
            } else {
                sum-=4;
                System.out.println("减后，sum="+sum);
            }
            try {
                sleep(500);// 睡眠0.5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}