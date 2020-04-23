package com.hyp.spring_study.spring_aop.proxy.cglib_aop_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * 增强demo
 * */
public class EnhancerDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());//设置回调
        EnhancerDemo demo = (EnhancerDemo)enhancer.create();
        demo.test();
        System.out.println("demo=" + demo);
    }

    public void test() {//被代理调用的方法
        System.out.println("------EnhancerDemo.test()------");
    }

    private static class MethodInterceptorImpl implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.err.println("before invok " + method);
            Object object = methodProxy.invokeSuper(o,objects);
            System.err.println("after invok " + method);
            return object;
        }
    }

}
