package com.hyp.java_multi_thread.example.ex2;

/**
 * 三．示例二：两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
 * */
public class Bank {

    // 假设一个账户有1000块钱
    public static int money = 2000;

    // 柜台Counter取钱的方法
    public void Counter(int money) {// 参数是每次取走的钱
        Bank.money -= money;//取钱后总数减少
        System.out.println("柜台取走了" + money + "还剩下" + (Bank.money));
    }

    // ATM取钱的方法
    public void ATM(int money) {// 参数是每次取走的钱
        Bank.money -= money;//取钱后总数减少
        System.out.println("ATM上取走了" + money + "还剩下" + (Bank.money));
    }

}