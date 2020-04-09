package com.hyp.java_pattern.create.singleton;

/**
 * 推荐二：使用该方式进行实现单例模式
 * */
public class SingletonForStatic {

    private static class SingletonHolder {
        private static final SingletonForStatic INSTANCE = new SingletonForStatic();
    }

    private SingletonForStatic (){}

    public static final SingletonForStatic getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
