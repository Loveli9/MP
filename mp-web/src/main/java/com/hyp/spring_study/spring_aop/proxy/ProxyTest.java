package com.hyp.spring_study.spring_aop.proxy;

import com.hyp.spring_study.spring_aop.proxy.jdk_aop_proxy.MyInvocationHandler;
import com.hyp.spring_study.spring_aop.proxy.jdk_aop_proxy.UserService;
import com.hyp.spring_study.spring_aop.proxy.jdk_aop_proxy.UserServiceImpl;

public class ProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService)myInvocationHandler.getProxy();
        proxy.add();
    }


}
