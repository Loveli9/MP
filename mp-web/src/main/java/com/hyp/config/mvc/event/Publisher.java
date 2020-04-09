package com.hyp.config.mvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish(Object source, String receiver, String content){
        applicationContext.publishEvent(new SendMsgEvent(source, receiver, content));
    }

}