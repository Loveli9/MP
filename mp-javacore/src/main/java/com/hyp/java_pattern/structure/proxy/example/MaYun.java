package com.hyp.java_pattern.structure.proxy.example;

public class MaYun implements ZiRanRen {
    public void eat() {
        System.out.println("今天吃满汉全席");
    }
    public void drink() {
        System.out.println("今天喝大西洋");
    }
    @Override
    public void Quanli() {
        System.out.println("我赋予我的代理律师来行使这些权利,此时代理律师全权代理我处理某些事务");
    }
}
