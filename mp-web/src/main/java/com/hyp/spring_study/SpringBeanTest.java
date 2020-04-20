package com.hyp.spring_study;

import com.hyp.spring_study.spring_bean.A;
import com.hyp.spring_study.spring_bean.AppConfig;
import com.hyp.spring_study.spring_bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringBeanTest {

    public static void main(String[] args) {

        //如何实例化BeanDefinition，这是过程
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(A.class);
        Scope scope = A.class.getDeclaredAnnotation(Scope.class);
        genericBeanDefinition.setScope(scope.value());

        System.out.println("XXXXXX");

        //new ClassPathXmlApplicationContext xml 的方式
        //new AnnotationConfigApplicationContext 注解的方式
        //注解配置应用上下文
        ApplicationContext ac1 = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(ac1.getBean("person"));
        //默认加载文件系统的配置文件，主要配置文件放在项目下、本地上、类路径下（3种位置）
        //配置文件加载
        //ApplicationContext ac2 = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
        ApplicationContext ac2 = new FileSystemXmlApplicationContext("file:C/applicationContext.xml");
        //默认加载ClassPath路径下的配置文件
        ApplicationContext ac3 = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //person为配置文件bean中自定义的id名称
        Person person1 = (Person)ac2.getBean("person");
        //person为配置文件bean中自定义的id名称
        Person person2 = (Person)ac3.getBean("person");

        //资源的封装，类路径加载
        Resource resource = new ClassPathResource("applicationContext.xml");
        //初始化spring容器的代码
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        //调用Bean
        //person为配置文件bean中自定义的id名称
        Person person3 = (Person)beanFactory.getBean("person");

    }

}
