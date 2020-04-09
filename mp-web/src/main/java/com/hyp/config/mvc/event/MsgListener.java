package com.hyp.config.mvc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @TODO //定义事件监听器，实现ApplicationListener
 * @Author Lensen
 * @Date 2018/7/22
 * @Description
 */
@Component
public class MsgListener implements ApplicationListener<SendMsgEvent> {
    @Override
    public void onApplicationEvent(SendMsgEvent sendMsgEvent) {
        sendMsgEvent.output();
        System.out.println(sendMsgEvent.receiver + "received msg : " + sendMsgEvent.content );
    }
}