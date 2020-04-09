package com.hyp.java_pattern.create.singleton;

import org.junit.Test;

/**
 * 单例总结：
 * 1、一个核心原理就是私有构造,并且通过静态方法获取一个实例。
 * 2、在这个过程中必须保证线程的安全性。
 * 3、推荐用静态内部内实现单例或加了Volatile关键字的双重检查单例
 * */
public class MainClass {

    private class Run extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
//                System.out.println(SingletonForStaticBlock.getInstance().hashCode());//静态块
//                System.out.println(SingletonForHunger.getInstance().hashCode());//饿汉
                System.out.println(SingletonForLazy.getInstance().hashCode());//双重检查单例，懒汉的一种
//                System.out.println(SingletonForStatic.getInstance().hashCode());//静态内部类
            }
        }
    }

    @Test
    public void test() {
        Run t1 = new Run();
        Run t2 = new Run();
        Run t3 = new Run();
        t1.start();
        t2.start();
        t3.start();
    }

}
