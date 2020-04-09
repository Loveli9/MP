package com.hyp.task.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * quartz配置 首先定义一个jobfactory，继承org.springframework.scheduling.quartz.SpringBeanJobFactory，实现任务实例化方式。
 * */
public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware
{
    private transient AutowireCapableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context)
    {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle)
            throws Exception
    {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
