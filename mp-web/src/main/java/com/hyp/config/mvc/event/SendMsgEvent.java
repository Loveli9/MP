package com.hyp.config.mvc.event;

import org.springframework.context.ApplicationEvent;

/**
 * @TODO // 自定义事件，继承ApplicationEvent接口
 * @Author Lensen
 * @Date 2018/7/22
 * @Description
 */
public class SendMsgEvent extends ApplicationEvent {

    private static final long serialVersionID = 1L;

    // 收件人
    public String receiver;

    // 收件内容
    public String content;

    public SendMsgEvent(Object source) {
        super(source);
    }

    public SendMsgEvent(Object source, String receiver, String content) {
        super(source);
        this.receiver = receiver;
        this.content = content;
    }

    public void output(){
        System.out.println("I had been sand a msg to " + this.receiver);
    }

}