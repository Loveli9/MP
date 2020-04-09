package com.hyp.spring_study.spring_aop;

import com.hyp.spring_study.spring_aop.service.UserSvc;
import com.hyp.spring_study.spring_aop.service.UserSvcImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@EnableAspectJAutoProxy
//@ComponentScan("com.hyp.spring_study.spring_aop.*")
public class SpringApplication {

    public static void main(String[] args) {
        //new ClassPathXmlApplicationContext xml 的方式
        //new AnnotationConfigApplicationContext 注解的方式
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(SpringApplication.class);
//        UserSvc helloService = ac.getBean(UserSvc.class);
//        UserSvcImpl userService = ac.getBean(UserSvcImpl.class);
        UserSvcImpl userService = (UserSvcImpl)ac.getBean("userSvcImpl");
//        System.out.println("helloService=" + helloService);
        System.out.println("userService=" + userService);
    }

}
