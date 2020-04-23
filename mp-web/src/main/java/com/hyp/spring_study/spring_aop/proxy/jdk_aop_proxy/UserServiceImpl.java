package com.hyp.spring_study.spring_aop.proxy.jdk_aop_proxy;

/**
 * 被代理接口的实现类
 * */
public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("------add()------");
    }
}
