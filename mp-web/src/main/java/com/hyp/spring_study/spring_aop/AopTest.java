package com.hyp.spring_study.spring_aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AopTest {

    //com.hyp.spring_study.spring_aop.service
    @Pointcut("execution(* com.hyp.spring_study.spring_aop.service.*.*(..))")
    private void pointcut() {

    }

    //前置增强
    @Before("com.hyp.spring_study.spring_aop.AopTest.pointcut()")
    public void before() {
        System.out.println("before...");
    }

    //后置增强
    @After("com.hyp.spring_study.spring_aop.AopTest.pointcut()")
    public void after() {
        System.out.println("after...");
    }

    //环绕增强
    @Around("com.hyp.spring_study.spring_aop.AopTest.pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        long currennt = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("消耗时间：" + (end - currennt) + "毫秒！");
        return proceed;
    }

}
