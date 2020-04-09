package com.hyp.java_pattern.create.singleton;

/**
 * 饿汉单例
 * */
public class SingletonForHunger {

    private static SingletonForHunger instance = new SingletonForHunger();

    private SingletonForHunger (){}

    public static SingletonForHunger getInstance() {
        return instance;
    }

}
