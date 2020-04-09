/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package com.hyp.java_pattern.create.prototype.prototypeAbs;

import lombok.Data;

import java.util.ArrayList;

/**
* @Description：   <p>BaseMessage </p>
 */
@Data
public abstract class BaseMessage {

    /**
     * 发件人
     */
    private String send;

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 消息
     */
    private String message;

    private ArrayList<String> imgList = new ArrayList<>();

    public void addImage(String image){
        getImgList().add(image);
    }

   /*
    * 发送消息
    */
    public void sendMessage(){
        System.out.println(getReceiver()+getMessage()+"  充气娃娃图片数量："+getImgList().size()+"  发件人："+getSend());
    }

}
