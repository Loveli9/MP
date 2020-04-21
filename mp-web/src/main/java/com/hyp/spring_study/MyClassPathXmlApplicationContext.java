package com.hyp.spring_study;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        //添加验证要求
        getEnvironment().setRequiredProperties("VAR");
    }
}
