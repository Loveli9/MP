package com.hyp.spring_study;

import com.hyp.spring_study.spring_bean.A;
import com.hyp.spring_study.spring_bean.AppConfig;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class Test {

    public static void main(String[] args) {
        //注解配置应用上下文
//        AnnotationConfigApplicationContext ac =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        System.out.println(ac.getBean("a"));


        //如何实例化BeanDefinition，这是过程
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(A.class);
        Scope scope = A.class.getDeclaredAnnotation(Scope.class);
        genericBeanDefinition.setScope(scope.value());

        System.out.println("XXXXXX");
    }

}
