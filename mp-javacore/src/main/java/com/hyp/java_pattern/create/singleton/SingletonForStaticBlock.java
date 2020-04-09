package com.hyp.java_pattern.create.singleton;

public class SingletonForStaticBlock {

    private static SingletonForStaticBlock instance = null;

    private SingletonForStaticBlock() {
    }

    static {
        instance = new SingletonForStaticBlock();
    }

    public static SingletonForStaticBlock getInstance() {
        return instance;
    }

}
