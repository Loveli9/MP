package com.hyp.java_multi_thread.example.ex2;

public class PersonA extends Thread {
    // 创建银行对象
    Bank bank;

    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonA(Bank bank) {
        this.bank = bank;
    }

    //重写run方法，在里面实现使用柜台取钱
    @Override
    public void run() {
        while (Bank.money >= 100) {
            bank.Counter(100);// 柜台每次取100块
            try {
                sleep(500);// 取完休息0.5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}