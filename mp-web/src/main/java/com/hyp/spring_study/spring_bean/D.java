package com.hyp.spring_study.spring_bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * bean后置处理器
 * */
@Component
public class D implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanDefinition a = (AbstractBeanDefinition)beanFactory.
                getBeanDefinition("a");
        a.setBeanClass(B.class);
    }
}
